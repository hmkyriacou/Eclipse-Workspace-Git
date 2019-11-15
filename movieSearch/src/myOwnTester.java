import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class myOwnTester {

	
	public static void main(String[] args) {
		IMDBGraphImpl imdbGraph = new IMDBGraphImpl(System.getProperty("user.dir") + "/src/actors_first_10000_lines.list", System.getProperty("user.dir") + "/src/actresses_first_10000_lines.list");
		GraphSearchEngineImpl searchEngine = new GraphSearchEngineImpl();
		
	}
}
