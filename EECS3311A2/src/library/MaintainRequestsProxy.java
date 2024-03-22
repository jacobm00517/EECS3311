package library;

import java.util.ArrayList;
import java.util.List;

public class MaintainRequestsProxy implements RequestDatabase {

	private String reqPath;
	private static RequestDatabase reqDB = MaintainRequests.getInstance();
	private static List<Request> reqL = new ArrayList<Request>();


	// ---- these vars were for manually figuring out the priority, but it is not set in stone so the Team manages it.
	private static List<Request> reqCT = new ArrayList<Request>();
	private static List<Request> reqSI = new ArrayList<Request>();

	private void initializeProxy() throws Exception {
		if (reqL.isEmpty()) {
			reqDB.load(pathNames.reqPath);
			reqL.addAll(reqDB.getRequests());
		}
	}

	@Override
	public void load(String reqPath) throws Exception {
		try {
			initializeProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() throws Exception {
		initializeProxy();
		reqDB.setRequests(reqL);
		reqDB.update();

	}

	@Override
	public String notifyPriority(Request r) {
		
		// could have been sent to observer if it was an observer pattern

		return r.getPriority();
	}

	// NOT NEEDED TBH JUST THERE INCASE. 
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
	public void confirmReq(Request req) {
		reqL.add(req);

	}
	@Override
	public void removeReq(Request req) {
		for (Request r: reqL) {
			if (reqL.contains(r)) {
				reqL.remove(r);
			}
		}

	}

	// --------- all
	@Override
	public List<Request> getRequests() {
		return this.reqL;
	}
	@Override
	public void setRequests(List<Request> r) {
		this.reqL = r;

	}


	// ------------- 
	@Override
	public void setReqSI(List<Request> r) {
		this.reqSI = r;
	}
	@Override
	public List<Request> getReqSI() {
		return this.reqSI;
	}
	@Override
	public void setReqCT(List<Request> r) {
		this.reqCT = r;
	}
	@Override
	public List<Request> getReqCT() {
		return this.reqCT;
	}
	

}
