package graphs.detectCycleInDirectGraph;

import java.util.LinkedList;

/*
    Approach - Using DFS & Recursion Stack

    1. Maintain Two Arrays:
        > visited[]: To check if a node has been visited.
        > recStack[]: To track nodes in the current recursion stack.

    2. DFS Traversal:
        > Mark the node as visited.
        > Mark the node in the recursion stack.
        > Recursively visit all adjacent nodes.
        > If an adjacent node is already in the recursion stack, a cycle exists.
        > After exploring all paths, remove the node from the recursion stack.

    3. If any cycle is found, return true.
*/
public class GraphCycleDetection {
    private int V;
    private LinkedList<Integer>[] adjList;

    GraphCycleDetection(int value){
        V = value;
        adjList = new LinkedList[value];
        for (int i = 0; i < value; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
        adjList[src].add(dest);
    }

    public static void main(String[] args) {
        GraphCycleDetection g = new GraphCycleDetection(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1); // This edge creates a cycle

        if (g.isCyclic())
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }

    private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack){
        if (recStack[node]){
            return true;
        }

        if (visited[node]){
            return false;
        }

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adjList[node]){
            if (isCyclicUtil(neighbor,visited,recStack)){
                return true;
            }
        }

        recStack[node]= false;
        return false;
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(i,visited,recStack)){
                return true;
            }
        }
        return false;
    }
}
