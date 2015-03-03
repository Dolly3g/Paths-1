import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

class Paths {
	public Map<String,Set<String>> pathsMap;
	public Set<String> allCities;
	public Paths(){
		pathsMap=new HashMap<String,Set<String>>();
		allCities=new HashSet<String>();
	}
	public boolean hasCity(String city){
		return allCities.contains(city);
	}
	public void addPath(String source, String destination){
		if(source==null || destination==null) return ;
		Set<String> allPaths=new HashSet<String>();
		if(pathsMap.containsKey(source))
			allPaths=pathsMap.get(source);
		allPaths.add(new String(destination));
		pathsMap.put(source,allPaths);
		allCities.add(source);
		allCities.add(destination);
	}
	public boolean hasPath(String source,String destination){
		if(!pathsMap.containsKey(source)) return false;
		Set<String> middleCities=pathsMap.get(source);
		if(middleCities.contains(destination)) return true;
		for (String middleCity: middleCities) {
			if(hasPath(middleCity,destination)) return true;
		}
		return false;
	}
	public boolean hasAnyPath(String source, String destination){
		return hasPath(source,destination) || hasPath(destination,source);
	}
	public Result search(String source, String destination){
		Result result=new Result();
		result.notFound=hasCity(source)?hasCity(destination)?null:destination:source;
		result.isAvailable=hasPath(source,destination);
		result.entirePath=findPath(source,destination);
		return result;
	}
	public List<String> findPath(String source, String destination){
		List<String> path=new ArrayList<String>();
		if(!pathsMap.containsKey(source)) return path;//false;
		Set<String> middleCities=pathsMap.get(source);
		if(middleCities.contains(destination)) return path;//true;
		for (String middleCity: middleCities) {
			if(hasPath(middleCity,destination)) return path;//true;
		}
		return path;//false;
	}
	public static void main(String[] args) {
		Paths paths=new Paths();
		paths.addPath("Bangalore","Singapore");
		paths.addPath("Singapore","Seoul");
		paths.addPath("Singapore","Dubai");
		paths.addPath("Seoul","Beijing");
		paths.addPath("Beijing","Tokyo");
		Result result=paths.search(args[0],args[1]);
		System.out.println(result.toString());
	}
}
class Result {
	public boolean isAvailable;
	public String notFound;
	public List<String> entirePath;
	@Override
	public String toString(){
		if(notFound!=null) return "No city named \""+notFound+"\" in database";
		if(isAvailable) return "true";
		else return "false";
	}
}
