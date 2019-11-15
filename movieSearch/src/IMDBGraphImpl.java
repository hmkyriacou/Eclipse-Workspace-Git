import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IMDBGraphImpl implements IMDBGraph {

	private HashMap<String, ActorNode> _people = new HashMap<String, ActorNode>();
	private HashMap<String, MovieNode> _movies = new HashMap<String, MovieNode>();
	
	public IMDBGraphImpl (String actorsFilePath, String actressesFilePath){
		Scanner actors = null;
		Scanner actresses = null;
		try {
			actors = new Scanner(new File (actorsFilePath), "ISO-8859-1");
			actresses = new Scanner(new File (actressesFilePath), "ISO-8859-1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		advanceToFirstName(actors);
		createGraph(actors);
		advanceToFirstName(actresses);
		createGraph(actresses);
		
	}

	private void createGraph(Scanner toParse) {
		String name = null;
		while (toParse.hasNextLine()) {
			String nextLine = toParse.nextLine();
			while (nextLine.equals("")) {nextLine = toParse.nextLine();}
			int num = nextLine.indexOf("\t");
			if (num > 0) {
				if (_people.get(name) == null || _people.get(name).getNeighbors() == null || _people.get(name).getNeighbors().isEmpty()) {
					_people.remove(name);
				}
				name = nextLine.substring(0, num);
				_people.put(name, new ActorNode(name));
			}
			updateGraph(nextLine, name);
		}

	}
	
	private void updateGraph(String line, String name) {
		if (!line.contains("(TV)") && line.charAt(0) != '"') {
			String movieName = line.substring(line.indexOf("\t") + 1, line.indexOf(')')+1);
			if (!_movies.containsKey(movieName))
				_movies.put(movieName, new MovieNode(movieName));
			_people.get(name).addNode(_movies.get(movieName));
			_movies.get(movieName).addNode(_people.get(name));
		}
	}

	/*
	private String getMovieOnLine(String line) {
		String ret = line.substring(line.lastIndexOf("\t")+1);
		if (!ret.contains("(TV)") && ret.charAt(0) != '"') {
			return ret.substring(0, ret.indexOf(')')+1);
		}
		return null;

	}*/

	private void advanceToFirstName(Scanner toAdvance) {
		while (toAdvance.hasNextLine()) {
			String nextLine = toAdvance.nextLine();
			while (nextLine.equals("")) {nextLine = toAdvance.nextLine();}
			if (nextLine.contains("Name\t\t\tTitles")) {
				nextLine = toAdvance.nextLine();
				//nextLine = toAdvance.nextLine();
				break;
			}
		}
	}

	public Collection<? extends Node> getActors() {
		return _people.values();
	}

	public Collection<? extends Node> getMovies() {
		return _movies.values();
	}

	public Node getMovie(String name) {
		return _movies.get(name);
	}

	public Node getActor(String name) {
		return _people.get(name);
	}

}
