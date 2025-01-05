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

    // Traversal BFS

    // Perform BFS traversal starting from a source vertex
    public void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        visited.add(source);
        queue.add(source);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");


            for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    // Perform DFS traversal starting from a source vertex
    public void dfs(int source) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(source);
        visited.add(source);

        System.out.println("DFS Traversal:");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(current + " ");

            // Visit all neighbors of the current vertex
            for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }




    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("Graph:");
        graph.printGraph();

        // Perform BFS traversal starting from vertex 1
        System.out.println("BFS starting from vertex 1:");
        graph.bfs(1);

        // Perform DFS traversal starting from vertex 1
        System.out.println("DFS starting from vertex 1:");
        graph.dfs(1);
    }
}
