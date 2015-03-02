import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Paths {
	public Map<String,List<String>> flightsMap;
	public Paths(){
		flightsMap=new HashMap<String,List<String>>();
	}
	public void addPath(String cityFrom, String cityTo){
		List<String> allDestinations=new ArrayList<String>();
		allDestinations.add(cityTo);
		flightsMap.put(cityFrom,allDestinations);
	}
	public String hasPath(String cityFrom, String cityTo){
		boolean availability=flightsMap.containsKey(cityFrom);
		return availability? "true" : "false";
	}
	public static void main(String[] args) {
		Paths paths=new Paths();
		paths.addPath("Bangalore","Singapore");
		paths.addPath("Singapore","Seoul");
		paths.addPath("Singapore","Dubai");
		paths.addPath("Seoul","Beijing");
		paths.addPath("Beijing","Tokyo");
		String availability=paths.hasPath(args[0],args[1]);
		System.out.println(availability);
	}
}
