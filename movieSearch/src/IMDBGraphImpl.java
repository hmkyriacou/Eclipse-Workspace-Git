import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IMDBGraphImpl implements IMDBGraph {

	private HashMap<String, ActorNode> _people = new HashMap<String, ActorNode>();
	private HashMap<String, MovieNode> _movies = new HashMap<String, MovieNode>();

	public IMDBGraphImpl (String actorsFilePath, String actressesFilePath) throws IOException {
		Scanner actors = new Scanner(new File (actorsFilePath), "ISO-8859-1");
		Scanner actresses = new Scanner(new File (actressesFilePath), "ISO-8859-1");

		advanceToFirstName(actors);
		advanceToFirstName(actresses);

		createGraph(actors);
		createGraph(actresses);
	}

	private void createGraph(Scanner toParse) {
		String name = null;
		while (toParse.hasNextLine()) {
			String nextLine = toParse.nextLine();
			if (nextLine.indexOf("\t") > 0) {
				name = nextLine.substring(0, nextLine.indexOf("/t"));
				_people.put(name, new ActorNode(name));
				updateGraph(nextLine, name);
			}
			updateGraph(nextLine, name);
		}

	}
	
	private void updateGraph(String line, String name) {
		String movieName = getMovieOnLine(line);
		if (!_movies.containsKey(movieName))
			_movies.put(movieName, new MovieNode(movieName));
		_people.get(name).addNode(_movies.get(movieName));
		_movies.get(movieName).addNode(_people.get(name));
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
