import java.util.Collection;
import java.util.HashMap;

public class ActorNode implements Node{

	private String _data;
	private HashMap<String, MovieNode> _neighbors = new HashMap<String, MovieNode>();
	
	public ActorNode (String data) {
		_data = data;
	}
	
	public void addNode(MovieNode node) {
		_neighbors.put(node.getName(), node);
		
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
