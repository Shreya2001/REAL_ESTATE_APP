package packers_and_movers;

public class Distance extends City{

	private int locationfrom;
	private int locationto;	
	private long distance;
	
	Distance(){
		this.locationfrom=0;
		this.locationto=0;
		this.distance=0;
	}
	
	Distance(City A, City B){
		this.locationfrom=A.getCityid();
		this.locationto=B.getCityid();
		this.distance=(Math.abs(locationto-locationfrom)*1000);
	}

	public int getLocationfrom() {
		return locationfrom;
	}

	public int getLocationto() {
		return locationto;
	}

	public long getDistance() {
		return distance;
	}

	public void setLocationfrom(int locationfrom) {
		this.locationfrom = locationfrom;
	}

	public void setLocationto(int locationto) {
		this.locationto = locationto;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Distance [locationfrom=" + locationfrom + ", locationto=" + locationto + ", distance=" + distance + "]";
	}

}
