import java.util.List;
import java.util.ArrayList;

class Paths {
	public List<Path> availablePaths;
	public Paths(){
		availablePaths=new ArrayList<Path>();
	}
	public void addPath(String from, String to){
		availablePaths.add(new Path(from,to));
	}
	public Path getPath(int index){
		return availablePaths.get(index);
	}
	public String hasPath(String from, String to){
		Boolean availability=availablePaths.contains(new Path(from,to));
		return availability.toString();
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
