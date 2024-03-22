package library;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainRequests implements RequestDatabase {

	private List<Request> reqCT = new ArrayList<Request>();
	private List<Request> reqSI = new ArrayList<Request>();
	private List<Request> allReqs = new ArrayList<Request>();


	String reqPath;
	private static MaintainRequests database = null;

	//private constructor
	private MaintainRequests() {

	}


	public static RequestDatabase getInstance() {
		if (database == null) {
			database = new MaintainRequests();
		}
		return database;
	}
	
	@Override
	public void load(String reqPath) throws Exception {
		CsvReader reader = new CsvReader(reqPath); 
		reader.readHeaders();
		

		while(reader.readRecord()){ 
			Request req;
		
			req = new Request();
			
			// newsletter system, status
			req.setName(reader.get("name"));
			req.setEdition(reader.get("edition"));
			req.setItemType(reader.get("itemType"));
			req.setPriority(reader.get("priority"));
			req.setPriority(reader.get("completion"));
		
//			RequestDatabase reqDatabase = new MaintainRequestsProxy();

			allReqs.add(req);
		}
		
	}
	
	@Override
	public void confirmReq(Request req) {
		if (req.getItemType().equals("course textbook")) { 	
			// prioritized over the others, will make it automatic
			// stored above selfimprovement rows
			req.setPriority(reqCT.size() + 1 + ""); //first come first serve
			reqCT.add(req);
		} else {
			// stored in row after all courseteaching rows
			req.setPriority(reqSI.size() + 1 + ""); 
			reqSI.add(req);
		}
		
		// merge two to have the complete list
		allReqs = new ArrayList<Request>();
		allReqs.addAll(reqCT);
		allReqs.addAll(reqSI);
		
	}
	
	@Override
	public String notifyPriority(Request r) {
		
		return r.getPriority();
	}
	
	// NOT NEEDED TBH! JUST THERE INCASE. BUT THERES NO REASON WHY IT WOULD SEND IT ! 
	// ask isha for clarification ^^
	@Override
	public void sendRequestAccept(AdminAccount a, Request r) {
		a.request_Accept(r);

	}
	@Override
	public void sendRequestDeny(AdminAccount a, Request r) {
		a.request_Deny(r);

	}
	
	@Override
	public void update() throws Exception {
	
		try {		
			CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.reqPath, false), ',');
			
			//name,userType,email,password
			csvOutput.write("user");
			csvOutput.write("name");
			csvOutput.write("edition");
			csvOutput.write("itemType");
			csvOutput.write("priority");
			csvOutput.write("completion");
		
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			
			for(Request s: allReqs){
				
				csvOutput.write(s.getUser().getEmail());
				csvOutput.write(s.getName());
				csvOutput.write(s.getEdition());
				csvOutput.write(s.getItemType());
				csvOutput.write(s.getPriority());
				
				csvOutput.endRecord();
			}
			csvOutput.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void removeReq(Request req) {
		for (Request r: allReqs) {
			if (allReqs.contains(r)) {
				allReqs.remove(r);
			}
		}
	}
	
	
	//getters & setters
	@Override
	public List<Request> getReqCT() {
		return reqCT;
	}
	@Override
	public List<Request> getReqSI() {
		return reqSI;
	}
	@Override
	public void setReqCT(List<Request> reqCT) {
		this.reqCT = reqCT;
	}
	@Override
	public void setReqSI(List<Request> reqSI) {
		this.reqSI = reqSI;
	}
	// all of them not just separate types.
	@Override
	public List<Request> getRequests() {
		return this.allReqs;
	}
	@Override
	public void setRequests(List<Request> allReqs) {
		this.allReqs = allReqs;
	}

	

}
