import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

class Paths {
	public List<Path> availablePaths;
	public Set<String> cities;
	public Paths(){
		availablePaths=new ArrayList<Path>();
		cities=new HashSet<String>();
	}
	public void addCity(String city){
		cities.add(city);
	}
	public boolean hasCity(String city){
		return cities.contains(city);
	}
	public void addPath(String from, String to){
		availablePaths.add(new Path(from,to));
		cities.add(from);
		cities.add(to);
	}
	public Path getPath(int index){
		return availablePaths.get(index);
	}
	public boolean hasPath(String from, String to){
		return availablePaths.contains(new Path(from,to));
	}
	public Result search(String from, String to){
		Result result=new Result();
		if(!hasCity(from))
			result.notFound=from;
		else if(!hasCity(to))
			result.notFound=to;
		result.isAvailable=hasPath(from,to);
		return result;
	}
	public static void main(String[] args) {
		Paths paths=new Paths();
		paths.addPath("Bangalore","Singapore");
		paths.addPath("Singapore","Seoul");
		paths.addPath("Singapore","Dubai");
		paths.addPath("Seoul","Beijing");
		paths.addPath("Beijing","Tokyo");
		Boolean availability=paths.hasPath(args[0],args[1]);
		System.out.println(availability.toString());
	}
}
class Result {
	public boolean isAvailable;
	public String notFound;
}