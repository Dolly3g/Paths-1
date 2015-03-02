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
		assertEquals(true,paths.hasPath("Bangalore","Singapore"));
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
		paths.addPath("SriLanka","Singapore");
		assertEquals(false,paths.hasPath("Bangalore","Singapore"));
	}
	@Test
	public void hasPath_gives_true_when_the_path_is_available_UP(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasPath("Bangalore","Seoul"));
		assertEquals(false,paths.hasPath("Seoul","Bangalore"));
	}
	@Test
	public void hasAnyPath_gives_true_when_the_path_is_available_UP_or_DOWN(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasAnyPath("Bangalore","Seoul"));
		assertEquals(true,paths.hasAnyPath("Seoul","Bangalore"));
	}
	@Test
	public void hasCity_gives_true_when_the_given_city_exists(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		assertEquals(true,paths.hasCity("Bangalore"));
	}
	@Test
	public void hasCity_gives_false_when_the_given_city_does_not_exists(){
		setUp();
		assertEquals(false,paths.hasCity("Bangalore"));
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
	public void addPath_does_not_add_when_the_from_place_is_null(){
		setUp();
		paths.addPath(null,"Bangalore");
		assertEquals(false,paths.hasCity(null));
		assertEquals(false,paths.hasCity("Bangalore"));
	}
	@Test
	public void addPath_does_not_add_when_the_to_place_is_null(){
		setUp();
		paths.addPath("Bangalore",null);
		assertEquals(false,paths.hasCity("Bangalore"));
		assertEquals(false,paths.hasCity(null));
	}
	@Test
	public void addPath_does_not_affect_previous_entries_on_new_entries(){
		setUp();
		paths.addPath("Chennai","Bangalore");
		paths.addPath("Bangalore","Pune");
		assertEquals(true,paths.hasPath("Chennai","Bangalore"));
		assertEquals(true,paths.hasPath("Bangalore","Pune"));
	}
	@Test
	public void result_contains_isAvailable_true_when_there_is_some_way_to_connect_2_cities(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Bangalore","Seoul");
		assertEquals(true,searchResult.isAvailable);
	}
	@Test
	public void result_toString_gives_the_message_not_found_in_db_when_the_city_is_not_found_in_db(){
		setUp();
		paths.addPath("Bangalore","Seoul");
		Result searchResult=paths.search("Seoul","Chennai");
		assertEquals("No city named \"Chennai\" in database",searchResult.toString());
	}
	@Test
	public void result_contains_isAvailable_true_when_there_is_some_way_to_connect_3_cities(){
		setUp();
		paths.addPath("Seoul","Bangalore");
		paths.addPath("Singapore","Seoul");
		Result searchResult=paths.search("Singapore","Bangalore");
		assertEquals(true,searchResult.isAvailable);
	}
	@Test
	public void result_contains_isAvailable_true_when_there_is_some_way_to_connect_4_cities(){
		setUp();
		paths.addPath("Chennai","Bangalore");
		paths.addPath("Bangalore","Pune");
		paths.addPath("Pune","Lucknow");
		Result searchResult=paths.search("Chennai","Lucknow");
		assertEquals(true,searchResult.isAvailable);
	}
}
