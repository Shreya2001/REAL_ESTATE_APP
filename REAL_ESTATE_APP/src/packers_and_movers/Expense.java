package packers_and_movers;

public interface Expense {
	default int calcExpense(Agency a, Distance d) {
		int cost;
		long dist=d.getDistance();
		if(dist>=10000) {
			cost = a.getCost(4);
		}
		else if(dist>=8000 && dist<10000) {
			cost = a.getCost(3);
		}
		else if(dist>=5000 && dist<8000) {
			cost = a.getCost(2);
		}
		else if(dist>=2000 && dist<5000) {
			cost = a.getCost(1);
		}
		else {
			cost = a.getCost(0);
		}
		return cost;
	}
}
