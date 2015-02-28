import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Paths {
	public Map<String,List<String>> flightsMap;
	public Paths(){
		flightsMap=new HashMap<String,List<String>>();
	}
	public void setRoute(String cityFrom, String cityTo){
		List<String> allDestinations=new ArrayList<String>();
		allDestinations.add(cityTo);
		flightsMap.put(cityFrom,allDestinations);
	}
	public String checkRoute(String cityFrom, String cityTo){
		boolean availability=flightsMap.containsKey(cityFrom);
		return availability? "true" : "false";
	}
}
