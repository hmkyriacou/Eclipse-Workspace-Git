import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class myOwnTester {

	
	public static void main(String[] args) {
		IMDBGraphImpl _myGraph = new IMDBGraphImpl(System.getProperty("user.dir") + "/src/actors_test.list", System.getProperty("user.dir") + "/src/actresses_test.list");
		System.out.println(_myGraph.getMovies());
		System.out.println(_myGraph.getMovie("Movie3 (2003)"));
		System.out.println(_myGraph.getActors());
		System.out.println(_myGraph.getActor("Actor1"));
		System.out.println(_myGraph.getActor("Actor2").getNeighbors());
	}

}
