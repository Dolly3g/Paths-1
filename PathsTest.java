import org.junit.Test;
import static org.junit.Assert.*;

public class PathsTest {
	public Paths paths;
	public void setUp(){
		paths=new Paths();
	}
	@Test
	public void addPath_creates_the_path_for_the_given_cities_and_adds(){
		setUp();
		paths.addPath("Bangalore","Singapore");
		Path path1=paths.getPath(0);
		Path path2=new Path("Bangalore","Singapore");
		assertEquals(true,path1.equals(path2));
	}
	@Test
	public void getPath_gives_the_path_at_the_given_index(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Path path1=paths.getPath(0);
		Path path2=new Path("Bangalore","Seoul");
		assertEquals(true,path1.equals(path2));
	}
}
