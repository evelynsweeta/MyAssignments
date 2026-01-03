package week3.day2.Assignments;

public class APIClient {
          public void sendRequest(String endpoint) {
        	  System.out.println("method 1:" +endpoint);
          }
          public void sendRequest(String endpoint,String requestBody,boolean requestStatus) {
        	  System.out.println("method 2:" +endpoint);
        	  System.out.println("method 2:" +requestBody);
        	  System.out.println("method 2:" +requestStatus);
          }
          public static void main(String[] args) {
			APIClient api=new APIClient();
			api.sendRequest("TEST API");
			api.sendRequest("EP", "RB", true);
		}
}
