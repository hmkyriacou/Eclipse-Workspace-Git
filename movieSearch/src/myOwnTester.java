import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javafx.stage.Stage;

public class myOwnTester {

	
	public static void main(String[] args) {
		IMDBGraphImpl imdbGraph = new IMDBGraphImpl(System.getProperty("user.dir") + "/src/actors_test.list", System.getProperty("user.dir") + "/src/actresses_test.list");
		GraphSearchEngineImpl searchEngine = new GraphSearchEngineImpl();
	
		System.out.println(imdbGraph.getMovies());
		for (Node x: imdbGraph.getMovies()) {
				System.out.print(x.getName() + ", ");
			}	
		//for (Node x: searchEngine.findShortestPath(imdbGraph.getActor("Affleck, Ben"), imdbGraph.getActor("Adams, Amy (III)"))) {
		//	System.out.print(x.getName() + ", ");
		//}		
	}
}
 