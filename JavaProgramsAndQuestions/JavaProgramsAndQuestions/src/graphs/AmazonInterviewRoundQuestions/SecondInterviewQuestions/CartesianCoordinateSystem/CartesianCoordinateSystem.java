package graphs.AmazonInterviewRoundQuestions.SecondInterviewQuestions.CartesianCoordinateSystem;

/*
    Assume a Cartesian coordinate system. You are given the position coordinates
    (x,y) of a set of N routers.
    All routers are capable of sending and receiving signals.
    Out of these N routers, One router is termed as “Source” and one
    specific router is termed as “Destination”.

    1. Each router has a maximum transmission range (K units)
    2. Each router will shut down after transmitting a message

    Determine whether the “Destination” router will receive a signal transmitted
    by the “Sender” router

    Constraints :

    1. N <= 10^4, K <= 10
    2. −10^6≤x,y≤10^6

    Sample Input 1:
    4
    0 0
    3 4
    6 8
    9 12
    5
    3
    0 2
    0 1
    1 3

    YES
    YES
    YES

    Sample Output 1:
    YES

    Sample Input 2:
    3
    0 0
    10 10
    20 20
    5
    0 2

    Sample Output 2:
    NO


    Approach

        1. Graph
            Store routers List
            roture - Node
            ED

        2. BFS
            SourceIndex -start
            Queue
            visted boolean
            destinationIndex

        3. Check the transmission Range (x1 - x2)


    //Helper Function
    static boolean isWithinRange(Routeer r1, Router r2, int k){
        return (Math.pow(r1.x-r2.x,2)) + (Math.pow(r1.y-r2.y,2)); ---> // ED
    }

    static boolean willTranmit(List<Router> routers, int sourceIndex, int k, int destinationIndex){
        int n = routers.size();

        if(n == 0){
            return false;
        }

        if(sourceIndex == destinationIndex){
            return true;
        }

        Queue<Interger> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.add(sourceIndex);

        visited[sourceIndex] = true;

        while(!q.isEmpty()){
            int currentNode = q.poll();

            Router currentRouter = routers.get(current);

            for(int i=0; i<N; i++){
                if(!visited[i] && isWithinRange(currentNode,routers.get(i),k)){
                    if(i == destinationIndex){
                        return true;
                    }

                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return false;
    }

    Explanation
        Graph Representation:
            We store all routers in a List<Router>.
            Each router is a node.
            We determine connectivity using Euclidean distance.

        Breadth-First Search (BFS) Traversal:
            Start from the sourceIndex.
            Use a queue to explore nearby routers.
            Mark visited routers (boolean[] visited).
            If we reach destIndex, return true (message is delivered).

        Checking Transmission Range:
            The distance formula (x1 - x2)² + (y1 - y2)² ≤ K² determines if two routers can connect.

    Time Complexity	O(N²) --> (Worst case: Checking all router pairs)
    Space Complexity --> O(N) (For visited array & queue)

*/
import java.util.*;

class CartesianCoordinateSystem {
    // Router class to hold (x, y) coordinates
    static class Router {
        int x, y;
        Router(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean canTransmit(List<Router> routers, int sourceIndex, int destIndex, int K) {
        int N = routers.size();
        if (N == 0) return false;

        // Edge case: if source and destination are the same
        if (sourceIndex == destIndex) return true;

        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(sourceIndex);
        visited[sourceIndex] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            Router currentRouter = routers.get(current);

            // Traverse all routers to find those within range
            for (int i = 0; i < N; i++) {
                if (!visited[i] && isWithinRange(currentRouter, routers.get(i), K)) {
                    if (i == destIndex) return true;  // Found destination
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    // Check if two routers are within transmission range K
    private static boolean isWithinRange(Router r1, Router r2, int K) {
        return (Math.pow(r1.x - r2.x, 2) + Math.pow(r1.y - r2.y, 2)) <= K * K;
    }

    public static void main(String[] args) {
        List<Router> routers = Arrays.asList(
                new Router(0, 0),   // Router 0 (Source)
                new Router(3, 4),   // Router 1
                new Router(8, 6),   // Router 2
                new Router(13, 9),  // Router 3 (Destination)
                new Router(10, 10)  // Router 4
        );

        int sourceIndex = 0;
        int destIndex = 3;
        int K = 5;  // Transmission range

        boolean result = canTransmit(routers, sourceIndex, destIndex, K);
        System.out.println(result ? "YES" : "NO");
    }
}