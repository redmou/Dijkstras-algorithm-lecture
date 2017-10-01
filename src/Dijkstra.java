import java.util.*;

public class Dijkstra {

  private final Graph graph;
  private final Vertex goal;
  
  public Dijkstra(Graph graph, Vertex goal) {
    this.graph = graph;
    this.goal = goal;
  }

  public void run() {
    List<Vertex> list = new ArrayList<Vertex>(graph.getNodes());
    while (!list.isEmpty()) {
      Vertex node = getMin(list);
      if (node.equals(goal))
        break;
      for (Vertex neighbor : graph.getChildren(node)) {
        int d = node.distance() + graph.getCost(node, neighbor);
        if (d < neighbor.distance()) {
          neighbor.setDistance(d);
          neighbor.setPrevious(node);
        }
      }
    }
  }
  
  public Vertex getMin(List<Vertex> list) {
    Vertex min = list.get(0);
    for (int i=0 ; i < list.size() ; i++) {
      if (list.get(i).distance() < min.distance())
        min = list.get(i);
    }
    list.remove(min);
    return min;
  }
}
