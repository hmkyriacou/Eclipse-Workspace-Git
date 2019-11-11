import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IMDBGraphImpl implements IMDBGraph {

	private ArrayList<Node> edges
	
	public IMDBGraphImpl (String actorsFilePath, String actressesFilePath) throws IOException {
		Scanner actors = new Scanner(new File (actorsFilePath), "ISO-8859-1");
		Scanner actresses = new Scanner(new File (actressesFilePath), "ISO-8859-1");
		
		advanceToFirstName(actors);
		advanceToFirstName(actresses);
		
		while (actors.hasNextLine()) {
			
		}
	}
	
	private void advanceToFirstName(Scanner toAdvance) {
		while (toAdvance.hasNextLine()) {
			String nextLine = toAdvance.nextLine();
			if (nextLine.contentEquals("Name\t\t\tTitles")) {
				nextLine = toAdvance.nextLine();
				nextLine = toAdvance.nextLine();
				break;
			}
		}
	}
	
	public Collection<? extends Node> getActors() {
		
		return null;
	}

	public Collection<? extends Node> getMovies() {
		return null;
	}

	public Node getMovie(String name) {
		return null;
	}

	public Node getActor(String name) {
		return null;
	}

}
