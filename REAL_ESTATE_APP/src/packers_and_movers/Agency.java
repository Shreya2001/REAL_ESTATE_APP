package packers_and_movers;

import java.util.ArrayList;
import java.util.Arrays;

public class Agency {
		private String agency;
		private String agent;
		private long contact;
		private int cost[];
		
		Agency(){
			this.agency="";
			this.agent="";
			this.contact=0;
			this.cost=new int[]{};
		}
		
		Agency(String agencyName, String agentName, long contactNumber, int arr[]){
			this.agency=agencyName;
			this.agent=agentName;
			this.contact=contactNumber;
			this.cost=arr;
		}

		
		public String getAgency() {
			return agency;
		}

		public String getAgent() {
			return agent;
		}

		public long getContact() {
			return contact;
		}

		public int getCost(int index) {
			return cost[index];
		}

		public void setAgency(String agency) {
			this.agency = agency;
		}

		public void setAgent(String agent) {
			this.agent = agent;
		}

		public void setContact(long contact) {
			this.contact = contact;
		}

		public void setCost(int[] cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "{ Agency =" + agency + ", agent=" + agent + ", contact=" + contact + "]";
		}
		
		
}
