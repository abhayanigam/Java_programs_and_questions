package graphs.breadthFirstSearchMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchMatrix {
    static class pair{
        int first, second;

        public pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static int ROW = 4;
    static int COL = 4;

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        BFS(grid,0,0);
    }

    private static void BFS(int[][] grid, int row, int col) {
        int[] dirRow = { -1, 0, 1, 0 };
        int[] dirCol = { 0, 1, 0, -1 };

        boolean [][]vis = new boolean[ROW][COL];

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(row, col));
        vis[row][col] = true;

        while(!q.isEmpty()){
            pair cell = q.peek();

            int x = cell.first;
            int y = cell.second;

            System.out.println(grid[x][y] + " ");

            q.remove();

            for (int i = 0; i < 4; i++) {
                int adjX = x + dirRow[i];
                int adjY = y + dirCol[i];

                if (isValid(vis, adjX, adjY)){
                    q.add(new pair(adjX, adjY));
                    vis[adjX][adjY] = true;
                }
            }
        }

    }

    private static boolean isValid(boolean[][] vis, int row, int col) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL){
            return false;
        }
        if (vis[row][col]){
            return false;
        }

        return true;
    }

}
