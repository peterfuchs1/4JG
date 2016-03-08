package mock.sensors;

import static org.junit.Assert.*;
import mock.Foo;
import mock.geofunctions.DistanceTo;
import mock.geofunctions.Position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRealGPS {
	
	private TrustworthyGPS gps;

	@Before
	public void setupMockTests() {		
		// Initialize our GPS
		gps=new TrustworthyGPS();
		// add the TGM Sight
		gps.setPositionOfSight("TGM", new Position());
	}

	@After
	public void tearDown() throws Exception {
		gps=null;
	}

	@Test
	public final void testDistanceToWithGPS() {
		DistanceTo dist=new DistanceTo(gps); // no exception raised
		assertNotNull(dist);
	}

	@Test(expected=IllegalArgumentException.class)
	public final void testDistanceToWithoutGPS() {
		DistanceTo dist=new DistanceTo(); // exception raised
		assertNotNull(dist);
	}	

	@Test
	public final void testGetPositionOfSight() {
		Position expected=new Position();
		Position actual=gps.getPositionOfSight("TGM");
		assertTrue(expected.compareTo(actual)==0);
	}

	@Test
	public final void testSetPositionOfSightStringDoubleDouble() {
		// is not implemented!!
		boolean created=gps.setPositionOfSight("Neu", 48.1234, 16.1234);
		assertFalse(created);
	}

	@Test
	public final void testSetPositionOfSightStringPosition() {
		Position expected= new Position(48.1234, 16.1234);
		gps.setPositionOfSight("Neu", expected);
		Position actual = gps.getPositionOfSight("Neu");
		assertTrue(expected.compareTo(actual)==0);
		
	}
	@Test
	public final void testDistanceOfEiffeltowerToEremitage() {
		Position eremitage= new Position(59.9398, 30.3145);
		Position eiffeltower=new Position(48.8584, 2.2945);
		double expected= 3327;
		double actual = DistanceTo.distanceFromTo(eremitage, eiffeltower, "K");
		assertEquals(expected, actual,0.6);
	}
	
	@Test
	public final void testDistanceOfAtomiumToEremitage() {
		Position eremitage= new Position(59.9398, 30.3145);
		Position atomium=new Position(50.9291, 4.3433);
		double expected= 1888;
		double actual = DistanceTo.distanceFromTo(eremitage, atomium, "M");
		assertEquals(expected, actual,0.6);
	}

	
}
