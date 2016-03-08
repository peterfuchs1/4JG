package mock.geofunctions;

public class Position implements Comparable<Position> {
	private double lat;
	private double lon;
	/**
	 * Position with 2 parameters
	 * @param lon longitude
	 * @param lat latitude
	 */
	public Position(double lon, double lat){
		this.lat=lat;
		this.lon=lon;
	}
	/**
	 * Position of TGM
	 */
	public Position(){
		this(48.23657, 16.36950);
	}

	@Override
	public int compareTo(Position pos2) {
		final int precession=5;
		int ret = (int)Math.floor(lon*precession-pos2.lon*precession);
		if (ret==0){
			ret = (int)Math.floor(lat*precession-pos2.lat*precession);
		}
		return ret;
	}

	// getter and setter
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	
}
