import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TheMap {

  public static String FILE_PATH = "src/graph.txt";
  
  public HashMap<String, Vertex> nodes;
  public Graph graph;
  
  public TheMap() {
    nodes = new HashMap<String, Vertex>();
    graph = new Graph();
    loadGraph();
  }
  
  public Graph getGraph() {
    return graph;
  }
  
  public void setStart(String stateName) {
    nodes.get(stateName).setDistance(0);
  }
  
  public Vertex getNode(String stateName) {
    return nodes.get(stateName);
  }
  
  private void loadGraph() {
    loadStates();
    loadEdges();
  }
  
  private void loadStates() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      String line;
      while ((line = br.readLine()) != null) {
        String sName = line.substring(0, line.indexOf("-"));
        Vertex s = new Vertex(sName);
        nodes.put(sName, s);
        graph.addNode(s);
      }
      br.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  private void loadEdges() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      String line;
      while ((line = br.readLine()) != null) {
        String s1 = line.substring(0, line.indexOf("-"));
        String[] adjacent = line.substring(
          line.indexOf("-") + 1).split(",");
        for (String s : adjacent) {
          String s2 = s.substring(0, s.indexOf("("));
          String cost = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
          graph.addEdge(
                  nodes.get(s1),
                  nodes.get(s2),
            Integer.parseInt(cost));
        }  
      }
      br.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }
  
  public static void main(String[] args) {

    String start = args[0];
    String end = args[1];

    TheMap map = new TheMap();
    map.setStart(start);
    Dijkstra d = new Dijkstra(map.getGraph(), map.getNode(end));
    d.run();
    
    List<Vertex> path = new ArrayList<Vertex>();
    Vertex node = map.getNode(end);
    
    while (node.previous() != null) {
      path.add(node);
      node = node.previous();
    }
    path.add(node);
    Collections.reverse(path);
    System.out.println("Shortest Path: " + path);
    System.out.println("Distance: " + map.getNode(end).distance());
    
  }
}
