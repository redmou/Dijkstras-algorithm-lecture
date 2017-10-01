public class Vertex {
  private final String name;
  private int distance; // distance between this vertex and the initial vertex
  private Vertex previous;

  public Vertex(String name) {
    this.name = name;
    this.distance = Integer.MAX_VALUE;
    this.previous = null;
  }

  public String name() {
    return name;
  }

  public int distance() {
    return distance;
  }
  
  public Vertex previous() {
    return previous;
  }
  
  public void setDistance(int d) {
    distance = d;
  }
  
  public void setPrevious(Vertex s) {
    previous = s;
  }

  public boolean equals(Object o) {
    if (o instanceof Vertex) {
      Vertex other = (Vertex) o;
      return this.name.equals(other.name);
    }
    return false;
  }

  public int hashCode() {
    return name.hashCode();
  }

  public String toString() {
    return name.toString();
  }
}
