package library;

import java.util.List;

public interface RequestDatabase {

	//allows only 1 instance of ItemDatabase, singleton pattern
		public static RequestDatabase getInstance() {
			return null;
		}
		
		public String notifyPriority(Request r);
		public void sendRequestAccept(AdminAccount a, Request r);
		public void sendRequestDeny(AdminAccount a, Request r);
		
		
		void load(String path) throws Exception;
		void update() throws Exception;

		void confirmReq(Request req);
		void removeReq(Request req);
		
		List<Request> getRequests();
		void setRequests(List<Request> systems);
		
		public List<Request> getReqCT();
		public List<Request> getReqSI();
		
		public void setReqCT(List<Request> reqSI);
		public void setReqSI(List<Request> reqSI);


		
		
}
