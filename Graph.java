import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge to the graph (undirected)
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Add an edge to the graph (directed)
    public void addDirectedEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    // Remove an edge from the graph (undirected)
    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove((Integer) destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove((Integer) source);
        }
    }

    // Remove a vertex from the graph
    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            for (Integer neighbor : adjacencyList.get(vertex)) {
                adjacencyList.get(neighbor).remove((Integer) vertex);
            }
            adjacencyList.remove(vertex);
        }
    }

    // Get the adjacency list
    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    // Print the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("Graph:");
        graph.printGraph();

        System.out.println("\nRemoving edge 1 -> 2:");
        graph.removeEdge(1, 2);
        graph.printGraph();

        System.out.println("\nRemoving vertex 3:");
        graph.removeVertex(3);
        graph.printGraph();
    }
}
