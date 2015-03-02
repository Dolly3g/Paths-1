import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest {
	public Paths flightPaths=new Paths();
	public void setUp(){
		flightPaths=new Paths();
	}
	@Test
	public void checkRoute_returns_true_for_available_route(){
		setUp();
		flightPaths.addPath("Bangalore","Singapore");
		String availability=flightPaths.hasPath("Bangalore","Singapore");
		assertEquals("true",availability);
	}
	@Test
	public void checkRoute_returns_false_when_no_flights_available_from_given_city(){
		setUp();
		String availability=flightPaths.hasPath("Bangalore","Singapore");
		assertEquals("false",availability);
	}
}
