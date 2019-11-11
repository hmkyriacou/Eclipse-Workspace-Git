import java.util.ArrayList;
import java.util.Collection;

public class GraphNode implements Node{

	private String _data;
	private ArrayList<Node> _neighbors;
	
	public GraphNode (String data) {
		_data = data;
	}
	
	public void addNode (Node node) {
		_neighbors.add(node);
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<? extends Node> getNeighbors() {
		// TODO Auto-generated method stub
		return null;
	}

}
