package graphs.graphsRepresentation;

import java.util.LinkedList;

public class GraphsRepresentation {
    private int V;
    private LinkedList<Integer>[] adjList;

    GraphsRepresentation(int value){
        V = value;
        adjList = new LinkedList[value];
        for (int i = 0; i < value; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest){
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    void printGraph(){
        for (int i = 0; i<V; i++){
            System.out.print(i + " -> ");
            for (int node : adjList[i]){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphsRepresentation g = new GraphsRepresentation(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
