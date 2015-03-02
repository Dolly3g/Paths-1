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
	@Test
	public void hasPath_gives_true_when_the_path_exists_between_two_given_cities(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasPath("Bangalore","Seoul"));
	}
	@Test
	public void hasPath_gives_false_when_the_path_does_not_exist(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		paths.addPath("Seoul","Singapore");
		assertEquals(false,paths.hasPath("Bangalore","Singapore"));
	}
	@Test
	public void hasPath_gives_true_when_the_path_is_available_UP_or_DOWN(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasPath("Bangalore","Seoul"));
		assertEquals(true,paths.hasPath("Seoul","Bangalore"));
	}
	@Test
	public void hasCity_gives_true_when_the_given_city_exists(){
		setUp();
		paths.addCity("Bangalore");
		assertEquals(true,paths.hasCity("Bangalore"));
	}
	@Test
	public void hasCity_gives_false_when_the_given_city_does_not_exists(){
		setUp();
		paths.addCity("Bangalore");
		assertEquals(false,paths.hasCity("Seoul"));
	}
	@Test
	public void addCity_adds_the_given_city_to_the_database(){
		setUp();
		paths.addCity("Bangalore");
		assertEquals(true,paths.hasCity("Bangalore"));
	}
	@Test
	public void search_returns_a_result_with_availability_true_for_existing_path(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Bangalore","Seoul");
		assertNotNull(searchResult);
		assertEquals(true,searchResult.isAvailable);
	}
	@Test
	public void search_returns_a_result_with_availability_false_for_a_non_existing_path(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Bangalore","Chennai");
		assertNotNull(searchResult);
		assertEquals(false,searchResult.isAvailable);
	}
	@Test
	public void search_stores_CITY_TO_in_notFound_when_it_is_not_found_in_the_database(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Bangalore","Chennai");
		assertNotNull(searchResult);
		assertEquals("Chennai",searchResult.notFound);
	}
	@Test
	public void search_stores_CITY_FROM_in_notFound_when_it_is_not_found_in_the_database(){
		setUp();
		paths.addPath("Chennai","Seoul");
		Result searchResult=paths.search("Bangalore","Chennai");
		assertNotNull(searchResult);
		assertEquals("Bangalore",searchResult.notFound);
	}
	@Test
	public void search_stores_null_in_notFound_when_the_cities_are_found_in_the_database(){
		setUp();
		paths.addPath("Chennai","Bangalore");
		Result searchResult=paths.search("Bangalore","Chennai");
		assertNotNull(searchResult);
		assertEquals(null,searchResult.notFound);
	}
	@Test
	public void addPath_adds_the_given_cities_to_the_database(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasCity("Bangalore"));
		assertEquals(true,paths.hasCity("Seoul"));
	}
	@Test
	public void result_toString_gives_the_message_true_when_the_path_is_found(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Bangalore","Seoul");
		assertEquals("true",searchResult.toString());
	}
	@Test
	public void result_toString_gives_the_message_false_when_the_path_is_not_found(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		paths.addPath("Singapore","Seoul");
		Result searchResult=paths.search("Singapore","Bangalore");
		assertEquals("false",searchResult.toString());
	}
	@Test
	public void result_toString_gives_the_message_not_found_in_db_when_the_city_is_not_found_in_db(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Seoul","Chennai");
		assertEquals("No city named \"Chennai\" in database",searchResult.toString());
	}
}
