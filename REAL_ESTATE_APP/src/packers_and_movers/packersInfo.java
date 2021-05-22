package packers_and_movers;

public class packersInfo extends Agency implements Expense{
	private int charge1;
	private int charge2;
	private int charge3;
	private Agency a1;
	private Agency a2;
	private Agency a3;
	private City c1;
	private City c2;
	private Distance d;
		
	packersInfo() {
		this.charge1=0;
		this.charge2=0;
		this.charge3=0;
	}
	
	packersInfo(String a, String b) {
		//declare three agencies working with us
		declareAgencies();
		//declare cities to and from
		declareCities(a,b);
		//compute distance
		d = new Distance(c1,c2); 
		//calculate expenditure based on company rates
		this.charge1 = calcExpense(a1,d);
		this.charge2 = calcExpense(a2,d);
		this.charge3 = calcExpense(a3,d);
	}
	
	public void declareAgencies() {
		long l1 = 632191822, l2 = 720217232, l3 = 604022652;
		int[] p1 = new int[]{1800,3500,5200,8200}, p2 = new int [] {4500,4700,5400,6400}, p3 = new int[] {2800,3000,6000,9000}; 
		this.a1=new Agency("Radhe Transport","Kumar Khanna",l1,p1);
		this.a2 = new Agency("SpeedEx Delivery","Akshay Manoj", l2,p2);
		this.a3 = new Agency("FastCourier Services","Surin Chawla",l3,p3);
	}
	
	public void declareCities(String a, String b) {
		c1 = new City(a);
		c2 = new City(b);
	}
	
	public static void main(String[] args) {
		
		packersInfo p = new packersInfo("delhi","kanyakumari");
		
		System.out.println("From: " + p.getC1());
		System.out.println("To: " + p.getC2());
		System.out.println("Distance: " + p.getD());
		System.out.println("");
		System.out.println("Agency: " + p.getA1().getAgency());
		System.out.println("Charge: "+p.getCharge1());
		System.out.println("");
		System.out.println("Agency: " + p.getA2());
		System.out.println("Charge: "+p.getCharge2());
		System.out.println("");
		System.out.println("Agency: " + p.getA3());
		System.out.println("Charge: "+p.getCharge3());
		
	}

	public int getCharge1() {
		return charge1;
	}

	public int getCharge2() {
		return charge2;
	}

	public int getCharge3() {
		return charge3;
	}

	public Agency getA1() {
		return a1;
	}

	public Agency getA2() {
		return a2;
	}

	public Agency getA3() {
		return a3;
	}

	public City getC1() {
		return c1;
	}

	public City getC2() {
		return c2;
	}

	public Distance getD() {
		return d;
	}

	public void setCharge1(int charge1) {
		this.charge1 = charge1;
	}

	public void setCharge2(int charge2) {
		this.charge2 = charge2;
	}

	public void setCharge3(int charge3) {
		this.charge3 = charge3;
	}

	public void setA1(Agency a1) {
		this.a1 = a1;
	}

	public void setA2(Agency a2) {
		this.a2 = a2;
	}

	public void setA3(Agency a3) {
		this.a3 = a3;
	}

	public void setC1(City c1) {
		this.c1 = c1;
	}

	public void setC2(City c2) {
		this.c2 = c2;
	}

	public void setD(Distance d) {
		this.d = d;
	}
	

}
