import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ActorNode implements Node{

	private String _data;
	private ArrayList<MovieNode> _neighbors = new ArrayList<MovieNode>();
	
	public ActorNode (String data) {
		_data = data;
	}
	
	public void addNode(MovieNode node) {
		_neighbors.add(node);
		
	}
	public String getName() {
		return _data;
	}

	public Collection<? extends Node> getNeighbors() {
		return _neighbors;
	}

}
