// Name:
// Student number:
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
 
public class Graph {
	
	private List<Vertex> verticesList;

	public Graph() {
		this.verticesList = new ArrayList<>();
	}

	public void addVertex(Vertex vertex) {
		this.verticesList.add(vertex);
	}

	public void reset() {
		for(Vertex vertex : verticesList) {
			vertex.setVisited(false);
			vertex.setPredecessor(null);
			vertex.setDistance(Double.MAX_VALUE);
		}
	}
/// Implement the methods below this line //////

	public List<Vertex> getShortestPath(Vertex sourceVertex, Vertex targetVertex) {

		// // Your code here// Graph.DijkstraShortestPath object = new Graph.DijkstraShortestPath(); // object.computeShortestPaths(sourceVertex);// return object.getShortestPathTo(targetVertex);
		List<Vertex> path = new ArrayList<>();
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;

	}

	public double getShortestPathDistance(Vertex sourceVertex, Vertex targetVertex) {

		// Your code here
		/*Graph.DijkstraShortestPath object = new Graph.DijkstraShortestPath(); 
		object.computeShortestPaths(sourceVertex);
		object.getShortestPathTo(targetVertex);*/
         computeShortestPaths(sourceVertex);
		return targetVertex.getDistance();
	}

public void computeShortestPaths(Vertex sourceVertex){
	sourceVertex.setDistance(0);
 		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
 		priorityQueue.add(sourceVertex);
 		sourceVertex.setVisited(true);
 
 		while( !priorityQueue.isEmpty() ){
             // Getting the minimum distance vertex from priority queue
 			Vertex actualVertex = priorityQueue.poll();
 
 			for(Edge edge : actualVertex.getAdjacenciesList()){
 
 				Vertex v = edge.getEndVertex();
 				if(!v.isVisited())
 				{
 					double newDistance = actualVertex.getDistance() + edge.getWeight();
 
 					if( newDistance < v.getDistance() ){
 						priorityQueue.remove(v);
 						v.setDistance(newDistance);
 						v.setPredecessor(actualVertex);
 						priorityQueue.add(v);
 					}
 				}
 			}
 			actualVertex.setVisited(true);  

 		}
 	}

}