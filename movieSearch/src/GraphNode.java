import java.util.ArrayList;
import java.util.Collection;

public class GraphNode<T> implements Node{

	private T _data;
	private ArrayList<Node> _neighbors;
	
	public GraphNode (T data) {
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
