package packers_and_movers;

public class City {
	private int cityid;
	private String cityname;
	
	City(){
		this.cityid=0;
		this.cityname="";
	}
	
	City(String name){
		int id=determineCityid(name);
		this.cityid=id;
		this.cityname=name;
	}

	public int determineCityid(String name) {
		int id=0;
		if(name.equalsIgnoreCase("kanyakumari")) {
			id = 0;
		}
		else if(name.equalsIgnoreCase("chennai")) {
			id = 1;
		}
		else if(name.equalsIgnoreCase("goa")) {
			id = 2;
		}
		else if (name.equalsIgnoreCase("pune")) {
			id = 3;
		}
		else if (name.equalsIgnoreCase("mumbai")) {
			id = 4;
		}
		else if(name.equalsIgnoreCase("ahmedabad")) {
			id = 5;
		}
		else if (name.equalsIgnoreCase("delhi")) {
			id = 8;
		}
		else if (name.equalsIgnoreCase("westbengal")) {
			id = 9;
		}
		return id;
	}
	
	public int getCityid() {
		return cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", cityname=" + cityname + "]";
	}
	
	
}
