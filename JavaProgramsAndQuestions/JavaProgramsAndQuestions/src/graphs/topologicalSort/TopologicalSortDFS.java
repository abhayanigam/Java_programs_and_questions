package graphs.topologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
//        int V = 6;
//        int V = 4;
        int V = 1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }

//        adj.get(5).add(2);
//        adj.get(5).add(0);
//        adj.get(4).add(0);
//        adj.get(4).add(1);
//        adj.get(2).add(3);
//        adj.get(3).add(1);

//        adj.get(0).add(1);
//        adj.get(0).add(2);
//        adj.get(1).add(3);
//        adj.get(2).add(3);

        adj.get(0).add(1);

        topologicalSort(V,adj);
    }

    private static void topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
