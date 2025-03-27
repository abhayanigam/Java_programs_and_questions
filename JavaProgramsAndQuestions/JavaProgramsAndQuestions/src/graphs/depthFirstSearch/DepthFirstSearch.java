package graphs.depthFirstSearch;

import java.util.LinkedList;

public class DepthFirstSearch {
    private int V;
    private LinkedList<Integer>[] adjList;

    DepthFirstSearch(int value){
        V = value;
        adjList = new LinkedList[value];

        for (int i = 0; i<value; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    /*
    // Recursive DFS method
    void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    // Helper function for DFS
    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
     */

    private void DFSUtil(int node, boolean[] visited) {
        if (visited == null) {
            visited = new boolean[V];
        }

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch g = new DepthFirstSearch(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("DFS starting from node 0:");
//        g.DFS(0);
        g.DFSUtil(0,null);
    }
}
