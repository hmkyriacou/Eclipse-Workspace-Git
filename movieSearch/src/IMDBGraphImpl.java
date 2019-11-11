import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IMDBGraphImpl implements IMDBGraph {
	
	private ArrayList<Node> _graph = new ArrayList<Node>();
	
	public IMDBGraphImpl (String actorsFilePath, String actressesFilePath) throws IOException {
		Scanner actors = new Scanner(new File (actorsFilePath), "ISO-8859-1");
		Scanner actresses = new Scanner(new File (actressesFilePath), "ISO-8859-1");
		
		advanceToFirstName(actors);
		advanceToFirstName(actresses);
		
		int index = -1;
		while (actors.hasNextLine()) {
			String nextLine = actors.nextLine();
			
			if (nextLine.substring(0, nextLine.indexOf("\t")).length() > 0) {
				if (getMovies(nextLine) != null) {
					_graph.add(new GraphNode(nextLine.substring(0, nextLine.indexOf("\t"))));
					index++;
					
				}
				
			}
		}
	}
	
	private String getMovies(String line) {
		String ret = line.substring(line.lastIndexOf("\t")+1);
		if (!ret.contains("(TV)") && ret.charAt(0) != '"') {
			return ret.substring(0, ret.indexOf(')')+1);
		}
		
	}
	
	private void advanceToFirstName(Scanner toAdvance) {
		while (toAdvance.hasNextLine()) {
			String nextLine = toAdvance.nextLine();
			if (nextLine.contentEquals("Name\t\t\tTitles")) {
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
