package other.data_structures_implementation.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

  private HashMap<String, List<String>> adjList = new HashMap<>();

  /**
   * Добавить вершину в граф.
   */
  public boolean addVertex(String vertex) {
    if (adjList.get(vertex) == null) {
      adjList.put(vertex, new ArrayList<>());
      return true;
    }
    return false;
  }

  /**
   * Добавить связь между двумя вершинами графами.
   */
  public boolean addEdge(String vertex1, String vertex2) {
    var vertex1List = adjList.get(vertex1);
    var vertex2List = adjList.get(vertex2);

    if (vertex1List != null && vertex2List != null) {
      if (!vertex1List.contains(vertex2) && !vertex2List.contains(vertex1)) {
        vertex1List.add(vertex2);
        vertex2List.add(vertex1);
        return true;
      }
    }
    return false;
  }

  /**
   * Удалить связь между двумя вершинами.
   */
  public boolean removeEdge(String vertex1, String vertex2) {
    var vertex1List = adjList.get(vertex1);
    var vertex2List = adjList.get(vertex2);

    if (vertex1List != null && vertex2List != null) {
      vertex1List.remove(vertex2);
      vertex2List.remove(vertex1);
      return true;
    }
    return false;
  }

  /**
   * Удалить вершину из графа.
   */
  public boolean removeVertex(String vertex) {
    var list = adjList.get(vertex);
    if (list == null) {
      return false;
    }
    if (list.isEmpty()) {
      adjList.remove(vertex);
    }

    list.forEach(otherVertex -> adjList.get(otherVertex).remove(vertex));
    adjList.remove(vertex);

    return true;
  }

  public void printGraph() {
    System.out.println(adjList);
  }
}

class GraphRunner {

  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addEdge("A", "B");
    graph.printGraph();

//    graph.removeEdge("A", "B");
    graph.removeVertex("A");
    graph.printGraph();
  }
}
