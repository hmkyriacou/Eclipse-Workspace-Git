import java.util.*;

public class GraphSearchEngineImpl implements GraphSearchEngine {

	public List<Node> findShortestPath(Node s, Node t) {
		ArrayList<Node> visitedNodes = new ArrayList<Node>();
		Queue<Node> nodesToVisit = new LinkedList<Node>();
		HashMap<Node, Integer> distanceFromS = new HashMap<Node, Integer>();
		
		Node n = null;
		nodesToVisit.add(s);
		distanceFromS.put(s, 0);
		while (nodesToVisit.size() > 0) {
			n = nodesToVisit.remove();
			
			if (n.equals(t)) {
				break;
			}
			
			visitedNodes.add(n);
			
			for (Node x : n.getNeighbors()) {
				if (!nodesToVisit.contains(x) && !visitedNodes.contains(x)) {
					nodesToVisit.add(x);
					distanceFromS.put(x, distanceFromS.get(n)+1);
				}
			}
			if (nodesToVisit.size() == 0) {
				return null;
			}
			
		}
		//System.out.println(n.getName());
		return backtrack(n, distanceFromS, s);
	}
	
	private List<Node> backtrack(Node t, HashMap<Node, Integer> distances, Node s){
		ArrayList<Node> visitedNodes = new ArrayList<Node>();
		Queue<Node> nodesToVisit = new LinkedList<Node>();
		ArrayList<Node> ret = new ArrayList<Node>();
		
		Node n;
		nodesToVisit.add(t);
		outerloop:
		while (nodesToVisit.size() > 0) {
			n = nodesToVisit.remove();
			
			visitedNodes.add(n);
			
			for (Node x : n.getNeighbors()) {
				if (distances.get(n) == 1) {
					break outerloop;
				}
				
				if (distances.get(x) == distances.get(n)-1) {
					ret.add(x);
				}
				
				
				if (!nodesToVisit.contains(x) && !visitedNodes.contains(x)) {
					nodesToVisit.add(x);
				}
			}
		}
		ret.add(s);
		Collections.reverse(ret);
		ret.add(t);
		return ret;
	}

}
