package graphs.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private int V;
    private LinkedList<Integer>[] adjList;

    BreadthFirstSearch(int value){
        V = value;
        adjList = new LinkedList[value];
        for (int i = 0;i<value; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    void BFS(int start){
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList[node]){
                if (!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("BFS starting from node 0:");
        g.BFS(0);
    }
}
