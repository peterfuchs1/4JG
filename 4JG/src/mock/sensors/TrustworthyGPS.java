package mock.sensors;

import java.util.HashMap;
import java.util.Random;

import mock.geofunctions.Position;

public class TrustworthyGPS implements PositionSensor {
	
	private Random r;
	private int c;
	private HashMap<String, Position> sights;
	
	public TrustworthyGPS() {
		r = new Random();
		c = 0;
		sights=new HashMap<String, Position>();
	}

	@Override
	public double getLongitude() {
		double lon = r.nextDouble()*360-180;
		if (c > 2 && c < 6)
			return 16.36950;
		else 
			return lon;
	}

	@Override
	public double getLatitude() {
		double lat = r.nextDouble()*180-90;
		if (c > 2 && c < 6)
			return 48.23657;
		else 
			return lat;
	}

	@Override
	public Position getPositionOfSight(String sight) {
		Position ret;
		if(sights.isEmpty())
			ret = new Position();
		else 
			ret = this.sights.get(sight);
		return ret;
	}

	@Override
	public boolean setPositionOfSight(String sight, double longitude,
			double latitude) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPositionOfSight(String sight, Position pos) {
		this.sights.put(sight, pos);
		return true;
	}
	

}
