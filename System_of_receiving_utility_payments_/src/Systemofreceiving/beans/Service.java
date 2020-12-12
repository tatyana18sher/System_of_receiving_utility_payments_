package Systemofreceiving.beans;

public class Service {

	   private String service_id;
	   private String service_name;
	   private String client;
	   private float payment;
	 
	   public Service() {
	 
	   }
	 
	   public Service(String service_id, String name, String client, float payment) {
	       this.service_id = service_id;
	       this.service_name = name;
	       this.client = client;
	       this.payment = payment;
	   }
	 
	   public String getServiceId() {
	       return service_id;
	   }
	 
	   public void setServiceId(String service_id) {
	       this.service_id = service_id;
	   }
	 
	   public String getServiceName() {
	       return service_name;
	   }
	 
	   public void setServiceName(String service_name) {
	       this.service_name = service_name;
	   }
	   
	   public String getClient() {
	       return client;
	   }
	 
	   public void setClient(String client) {
	       this.client = client;
	   }
	   public float getPayment() {
	       return payment;
	   }
	 
	   public void setPayment(float payment) {
	       this.payment = payment;
	   }
}

