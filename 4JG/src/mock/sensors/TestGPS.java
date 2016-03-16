package mock.sensors;

import static org.junit.Assert.*;
import mock.geofunctions.DistanceTo;
import mock.geofunctions.Position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
public class TestGPS {
	
	@Mock
	private TrustworthyGPS gps;

	@Before
	public void setupMockTests() {		
		// Initialize annotations for mockito
		MockitoAnnotations.initMocks(this);
		Position tgm=new Position();
		when(gps.getLongitude()).thenReturn(tgm.getLon());
		when(gps.getLatitude()).thenReturn(tgm.getLat());
		when(gps.getPositionOfSight("Eiffeltower")).thenThrow(new IllegalArgumentException());
		when(gps.getPositionOfSight("Atomium")).thenThrow(new IllegalArgumentException());
		when(gps.getPositionOfSight("TGM")).thenReturn(tgm);
	}

	@After
	public void tearDown() throws Exception {
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
	public final void testGetLongitude() {
		double expected= new Position().getLon();
		double actual = gps.getLongitude();
		assertEquals(expected, actual,0);
	}

	@Test
	public final void testGetLatitude() {
		double expected= new Position().getLat();
		double actual = gps.getLatitude();
		assertEquals(expected, actual,0);
	}

	@Test
	public final void testGetPositionOfSightTGM() {
		Position expected=new Position();
		Position actual=gps.getPositionOfSight("TGM");
		assertTrue(expected.compareTo(actual)==0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testGetPositionOfSightEiffeltower() {
		Position expected=new Position();
		Position actual=gps.getPositionOfSight("Eiffeltower");
		assertTrue(expected.compareTo(actual)==0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testGetPositionOfSightAtomium() {
		Position expected=new Position();
		Position actual=gps.getPositionOfSight("Atomium");
		assertTrue(expected.compareTo(actual)==0);
	}
	
	@Test
	public final void testSetPositionOfSightStringDoubleDouble() {
		// not implemented!!
		boolean actual=gps.setPositionOfSight("Eiffeltower", 48.8584, 2.2945);
		assertFalse(actual);
	}

	@Test
	public final void testSetPositionOfSightStringPosition() {
		boolean actual=gps.setPositionOfSight("Eiffeltower", new Position(48.8584, 2.2945));
		assertFalse(actual);
	}
	@Test
	public final void testDistanceToEiffeltower() {
		double lat1=gps.getLatitude();
		double lon1=gps.getLongitude();
		Position eiffeltower=new Position(48.8584, 2.2945);
		double lat2=eiffeltower.getLat();
		double lon2=eiffeltower.getLon();
		double actual = DistanceTo.distanceFromTo(lat1, lon1, lat2, lon2, "K");
		double expected = 1037;
		assertEquals(expected, actual, 0.6);
	}
	
	@Test
	public final void testDistanceToAtomium() {
		double lat1=gps.getLatitude();
		double lon1=gps.getLongitude();
		Position atomium=new Position(50.9291, 4.3433);
		double lat2=atomium.getLat();
		double lon2=atomium.getLon();
		double actual = DistanceTo.distanceFromTo(lat1, lon1, lat2, lon2, "M");
		double expected = 569;
		assertEquals(expected, actual, 0.6);
	}
	
	
}
