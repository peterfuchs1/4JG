package mock.sensors;

public interface PositionSensor {
	/**
	 * Returns the longitude of the actual position of the sensor
	 * @return longitude as decimal value (degrees)
	 */
	public double getLongitude();
	
	/**
	 * Returns the latitude of the actual position of the sensor
	 * @return latitude as decimal value (degrees)
	 */
	public double getLatitude();
	
	/**
	 * Returns the geographical position of a sight (like "Eiffeltower")
	 * The allowed sights are stored in a database.
	 * @param sight name of the sight to get position from
	 * @return array with longitude/latitude (in this order)
	 * @throws IllegalArgumentException if sight unknown
	 */
	public double[] getPositionOfSight(String sight);
	
	/**
	 * Stores the position of a sight in a database
	 * @param sight sight to store position for
	 * @param longitude longitude of the position in degrees
	 * @param latitude latitude of the position in degrees
	 * @return true if writing to db was a success, false otherwise
	 */
	public boolean setPositionOfSight(String sight, double longitude, double latitude);
	
}
