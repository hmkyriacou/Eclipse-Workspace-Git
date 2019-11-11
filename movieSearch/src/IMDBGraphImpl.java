import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IMDBGraphImpl implements IMDBGraph {

	private ArrayList<Node> _graph = new ArrayList<Node>();
	private HashMap<String, Node> _people = new HashMap<String, Node>();
	private HashMap<String, Node> _movies = new HashMap<String, Node>();

	public IMDBGraphImpl (String actorsFilePath, String actressesFilePath) throws IOException {
		Scanner actors = new Scanner(new File (actorsFilePath), "ISO-8859-1");
		Scanner actresses = new Scanner(new File (actressesFilePath), "ISO-8859-1");

		advanceToFirstName(actors);
		advanceToFirstName(actresses);

		createGraph(actors);
		createGraph(actresses);
	}

	private void createGraph(Scanner toParse) {
		while (toParse.hasNextLine()) {
			String nextLine = toParse.nextLine();
			if (nextLine.indexOf("\t") > 0) {
				String name = nextLine.substring(0, nextLine.indexOf("/t")+1);
				String movieName = getMovieOnLine(nextLine);
				_people.put(name, new GraphNode(name));
				_movies.put(movieName, new GraphNode(movieName));
			}
		}

	}

	private String getMovieOnLine(String line) {
		String ret = line.substring(line.lastIndexOf("\t")+1);
		if (!ret.contains("(TV)") && ret.charAt(0) != '"') {
			return ret.substring(0, ret.indexOf(')')+1);
		}
		return null;

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
