package graphs.solution;

import java.util.*;

class Result {
    /*
     * Complete the 'minimumDistance' function below.
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY area as parameter.
     */

    public static int minimumDistance(List<List<Integer>> area) {
        int rows = area.size();
        int cols = area.get(0).size();

        // Direction vectors (right, down, left, up)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS queue to store {row, col, distance}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // Start from (0,0) with distance 0

        // Visited set
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], distance = current[2];

            // If we reached the destination (9), return the distance
            if (area.get(x).get(y) == 9) {
                return distance;
            }

            // Explore all possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];

                // Check if within bounds, not visited, and is a valid cell
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && area.get(newX).get(newY) != 0 && !visited[newX][newY]) {

                    queue.offer(new int[]{newX, newY, distance + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        // If we exit the loop, no path was found
        return -1;
    }
}

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> area = Arrays.asList(
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 9, 1)
        );
        System.out.println(Result.minimumDistance(area)); // Output: 3
    }
}
