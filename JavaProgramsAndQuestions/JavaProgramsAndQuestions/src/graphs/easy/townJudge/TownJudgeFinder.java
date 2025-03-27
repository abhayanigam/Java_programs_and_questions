package graphs.easy.townJudge;

/*
    Since the problem can be modeled as a directed graph, we can solve it using in-degree and out-degree:

    In-degree (in[i]): The number of people who trust person i.
    Out-degree (out[i]): The number of people whom person i trusts.

    Graph Representation
        > A Town Judge must have:
            > out[judge] == 0 (The judge trusts no one)
            > in[judge] == N - 1 (Everyone else trusts the judge)
 */
public class TownJudgeFinder {
    public static void main(String[] args) {
        TownJudgeFinder finder = new TownJudgeFinder();

        System.out.println(finder.findJudge(2, new int[][]{{1, 2}})); // Output: 2
        System.out.println(finder.findJudge(3, new int[][]{{1, 3}, {2, 3}})); // Output: 3
        System.out.println(finder.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // Output: -1
        System.out.println(finder.findJudge(3, new int[][]{{1, 2}, {2, 3}})); // Output: -1
        System.out.println(finder.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}})); // Output: 3
    }

    private int findJudge(int N, int[][] trusts) {
        int[] inDegree = new int[N+1];
        int[] outDegree = new int[N+1];

        for (int[] t : trusts){
            int a = t[0], b = t[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int i = 1; i<=N; i++){
            if (inDegree[i] == N-1 && outDegree[i] == 0){
                return i;
            }
        }

        return -1;
    }
}
