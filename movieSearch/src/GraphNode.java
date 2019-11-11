import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GraphNode implements Node{

	private String _data;
	private HashMap<String, Node> _neighbors = new HashMap<String, Node>();
	
	public GraphNode (String data) {
		_data = data;
	}
	
	public void addNode (Node node) {
		_neighbors.put(node.getName(), node);
	}
	
	public String getName() {
		return _data;
	}

	public Collection<? extends Node> getNeighbors() {
		// TODO Auto-generated method stub
		return null;
	}

}
