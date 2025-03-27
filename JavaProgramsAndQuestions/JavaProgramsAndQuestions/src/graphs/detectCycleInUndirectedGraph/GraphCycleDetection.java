package graphs.detectCycleInUndirectedGraph;

/*
    Approach - Using DFS (Depth-First Search)

    1. Maintain Two Arrays:
        > visited[]: To check if a node has been visited.
        > parent: To track the parent of each node.
    2. DFS Traversal:
        > Mark the current node as visited.
        > Explore all adjacent nodes.
        > If an adjacent node is already visited but not the parent, then a cycle exists.
    3. If any cycle is found, return true.
 */

import java.util.LinkedList;

public class GraphCycleDetection {
    private final int V;
    private final LinkedList<Integer>[] adjList;

    GraphCycleDetection(int value){
        V = value;
        adjList = new LinkedList[value];
        for (int i = 0; i<value; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    // Add undirected edge
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Since it's an undirected graph
    }

    // Detect cycle in an undirected graph
    boolean isCyclic() {
        boolean[] visited = new boolean[V];

        // Check cycle for each component (for disconnected graphs)
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, -1))
                return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adjList[node]){
            if (!visited[neighbor]){
                if (isCyclicUtil(neighbor,visited,node)){
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GraphCycleDetection g = new GraphCycleDetection(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1); // This edge creates a cycle

        if (g.isCyclic())
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }
}
