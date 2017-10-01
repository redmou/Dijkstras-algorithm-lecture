import java.util.*;

public class Graph {

  /**
   * Each vertex is presented in Map contains information
   * about it's name and names of other vertexes it's connected to
   * and the distance between them
   */
  private Map<Vertex, HashMap<Vertex, Integer>> graph;
  
  
  /**
   * Constructs a new Graph
   * @effects Constructs a new Graph
   */
  public Graph() {
    graph = new HashMap<Vertex, HashMap<Vertex, Integer>>();
  }
  
  /**
   * Adds a node to a Graph
   * @requires node != null && node not already in this
   * @modifies this
   * @effects adds a node to this
   */
  public void addNode(Vertex node) {
    HashMap<Vertex, Integer> map = new HashMap<Vertex, Integer>();
    graph.put(node, map);
  }
  
  /**
   * Add an edge to a Graph
   * @requires n1 != null && n2 != null && n1,n2 exist in this 
   * && edge between n1 and n2 does not exist already
   * @modifies this
   * @effects makes an edge from node1 to node2
   */
  public void addEdge(Vertex n1, Vertex n2, int cost) {
    graph.get(n1).put(n2, cost);
  }
  
  
  /**
   * @return the collection of the nodes that form this
   */
  public List<Vertex> getNodes() {
    List<Vertex> nodes = new ArrayList<Vertex>(graph.keySet());
    return nodes;
  }
  
  /**
   * @return the collection of nodes that are children of node 
   */
  public List<Vertex> getChildren(Vertex node) {
    List<Vertex> children = new ArrayList<Vertex>(graph.get(node).keySet());
    return children;
  }
  
  public Integer getCost(Vertex n1, Vertex n2) {
    return graph.get(n1).get(n2);
  }
  
  
} // Graph
