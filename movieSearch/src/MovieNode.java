import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MovieNode implements Node {

	private String _data;
	private ArrayList<ActorNode> _actors = new ArrayList<ActorNode>();
	
	public MovieNode (String data) {
		_data = data;
	}
	
	public void addNode(ActorNode node) {
		_actors.add(node);
		
	}
	
	public String getName() {
		return _data;
	}

	public Collection<? extends Node> getNeighbors() {
		return _actors;
	}

}
