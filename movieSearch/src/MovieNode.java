import java.util.Collection;
import java.util.HashMap;

public class MovieNode implements Node {

	private String _data;
	private HashMap<String, ActorNode> _actors = new HashMap<String, ActorNode>();
	
	public MovieNode (String data) {
		_data = data;
	}
	
	public void addNode(ActorNode node) {
		_actors.put(node.getName(), node);
		
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
