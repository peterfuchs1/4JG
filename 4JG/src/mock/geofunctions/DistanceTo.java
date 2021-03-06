package mock.geofunctions;

import mock.sensors.PositionSensor;

public class DistanceTo
{
	private PositionSensor pos;
	
	/**
	 * Constructor
	 * @param pos a position sensor
	 */
	public DistanceTo(PositionSensor pos) {
		if (pos != null) {
			this.pos = pos;
		} else {
			throw new IllegalArgumentException("Only useful with position sensor");
		}
	}
	
	/**
	 * Constructor
	 * 
	 */
	public DistanceTo() {
		this(null);
	}

	/**
	 * Calculates the distance between the actual position (given by the sensor) and
	 * the position in the parameters
	 * @param lat1 latitude of the point we want to know the distance to
	 * @param lon1 longitude of the point we want to know the distance to
	 * @param unit unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance in the given unit
	 */
	public double distanceTo(double lon1,double lat1,  String unit) {
		return DistanceTo.distanceFromTo(lon1,lat1,pos.getLongitude(),pos.getLatitude(), unit);
	}
	/**
	 * Calculates the distance between the actual position (given by the sensor) and
	 * the position in the parameters
	 * @param lat1 latitude of the point we want to know the distance to
	 * @param lon1 longitude of the point we want to know the distance to
	 * @param unit unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance in the given unit
	 */
	public double distanceTo(Position pos1, String unit) {
		return DistanceTo.distanceFromTo(pos1.getLon(),pos1.getLat(),pos.getLongitude(),pos.getLatitude(), unit);
	}
	
	/**
	 * Calculates the distance between two positions (given by a sensor) and in the parameters
	 * @param pos1 first position from a sensor
	 * @param pos2 second position from a sensor
	 * @param unit unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance in the given unit
	 */
	public static double distanceFromTo(PositionSensor pos1, Position pos2, String unit){
		return DistanceTo.distanceFromTo(pos1.getLongitude(),pos1.getLatitude(),pos2.getLon(),pos2.getLat(), unit);
	}
	/**
	 * Calculates the distance between two positions in the parameters
	 * @param pos1 first position 
	 * @param pos2 second position 
	 * @param unit unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance in the given unit
	 */

	public static double distanceFromTo(Position pos1, Position pos2, String unit){
		return DistanceTo.distanceFromTo(pos1.getLon(),pos1.getLat(),pos2.getLon(),pos2.getLat(), unit);
	}

	/**
	 * Calculates the distance between two positions in the parameters
	 * @param lat1 latitude of the point we want to know the distance to
	 * @param lon1 longitude of the point we want to know the distance to
	 * @param lat2 latitude of the point we want to know the distance to
	 * @param lon2 longitude of the point we want to know the distance to
	 * @param unit unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance in the given unit
	 */
	public static double distanceFromTo(double lon1,double lat1, double lon2, double lat2,  String unit){
		
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		
		return dist;
	}
	
	/**
	 * Gives the distance to a specific sight. This sight has to be placed in the
	 * Database with the according method of the position sensor.
	 * @param sight name of the sight. Has to exist in the db.
	 * @param unit  unit of the distance. can be M (miles) or K (kilometers) or N (nautical miles)
	 * @return distance to the given sight in the given unit
	 */
	public double howFarTo(String sight, String unit) {
		Position sightpos = this.pos.getPositionOfSight(sight);
		double distance = distanceTo(sightpos, unit);
		return distance;
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
