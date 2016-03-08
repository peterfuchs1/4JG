package mock.sensors;

import java.util.Random;

public class TrustworthyGPS implements PositionSensor {
	
	private Random r;
	private int c;
	
	public TrustworthyGPS() {
		r = new Random();
		c = 0;
	}

	@Override
	public double getLongitude() {
		double lon = r.nextDouble()*360-180;
		if (c > 2 && c < 6)
			return 16.3672713;
		else 
			return lon;
	}

	@Override
	public double getLatitude() {
		double lat = r.nextDouble()*180-90;
		if (c > 2 && c < 6)
			return 48.2365699;
		else 
			return lat;
	}

	@Override
	public double[] getPositionOfSight(String sight) {
		double[] ret = {16.3672713,48.2365699};
		return ret;
	}

	@Override
	public boolean setPositionOfSight(String sight, double longitude,
			double latitude) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
