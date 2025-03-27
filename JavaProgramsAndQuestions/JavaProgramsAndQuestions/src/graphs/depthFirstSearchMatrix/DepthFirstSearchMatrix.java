package graphs.depthFirstSearchMatrix;

import java.util.Stack;

public class DepthFirstSearchMatrix {
    static int ROW = 3;
    static int COL = 3;

//    static int[][] directions= {{0,1},{1,0},{0,-1},{-1,0}};
    static int dRow[] = { 0, 1, 0, -1 };
    static int dCol[] = { -1, 0, 1, 0 };

    static class pair{
        public int first;
        public int second;

        public pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int grid[][] = { { -1, 2, 3 },
                { 0, 9, 8 },
                { 1, 0, 1 } };

        Boolean vis[][] = new Boolean[ROW][COL];
        for(int i = 0; i < ROW; i++)
        {
            for(int j = 0; j < COL; j++)
            {
                vis[i][j] = false;
            }
        }

        // Function call
        DFS(0, 0, grid, vis);
    }

    private static void DFS(int row, int col, int[][] grid, Boolean[][] vis) {
        Stack<pair> st = new Stack<>();
        st.push(new pair(row,col));

        while(!st.isEmpty()){
            pair curr = st.pop();

            row = curr.first;
            col = curr.second;

            if(!isValid(vis,row, col)){
                continue;
            }

            vis[row][col] = true;

            System.out.print(grid[row][col] + " ");

//            for(int[] dir : directions){
//                int rowX = row + dir[0];
//                int colY = col + dir[1];
//
//                st.push(new pair(rowX,colY));
//            }

            for(int i = 0; i < 4; i++)
            {
                int adjx = row + dRow[i];
                int adjy = col + dCol[i];
                st.push(new pair(adjx, adjy));
            }

        }
    }

    private static boolean isValid(Boolean[][] vis, int row, int col) {
        if(row < 0 || col < 0 || row >= ROW || col >= COL){
            return false;
        }

        if (vis[row][col]){
            return false;
        }

        return true;
    }
}
