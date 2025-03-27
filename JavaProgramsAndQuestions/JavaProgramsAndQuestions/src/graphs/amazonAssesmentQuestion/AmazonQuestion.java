package graphs.amazonAssesmentQuestion;

/*
    Amazon Fresh is a grocery delivery service that offers consumers the option of purchasing their
    groceries online and having them delivered on schedule. The Amazon Fresh team is planning a route
    for a delivery truck to deliver customer orders in the city of TechIndia. The planner will create a
    delivery area for each order to effectively plan the route. The area is abstracted as a grid.
    Not all locations are accessible by road. The truck only needs to make a single delivery.
    Write an algorithm to determine the minimum distance required for the truck to deliver the order.

    Assumptions:
    Some places in the delivery area cannot be accessed by the driver, as there are no roads in those locations.
    The delivery area can be represented as a two-dimensional grid of integers,
    where each integer represents one cell.
    The truck must start from the top-left corner of the area, which is always accessible and can move one cell up,
    down, left, or right at a time.

    The truck must navigate around the areas without roads and cannot leave the area.
    The accessible areas are represented as 1, areas without roads are represented by 0
    and the order destination is represented by 9.

    Input
    The input to the function/method consists of one argument:
        area, representing the two-dimensional grid of integers.

    Output
    Return an integer representing the total distance traversed to deliver the order else return -1.

    Constraints
    1 s rows, columns ≤ 103

    Example
        Input:
            area =
                [[1,0,0],
                [1,0,0],
                [1, 9, 1]]

    Output: 3

    Explanation:
    Starting from the top-left corner, the truck traversed the cells (0,0) -> (1,0) -> (2,0) -> (2,1).
    The truck traversed the total distance to deliver the order.

    So, the output is 3.

    Approach
    1. Use BFS (Breadth-First Search):
           BFS is ideal because it explores all possible moves level by level, guaranteeing the shortest path.

    2. Track Visited Cells:
           Use a boolean[][] visited array to avoid revisiting cells.

    3. Process Neighbors:
           The truck can move up, down, left, or right.
           Only enqueue valid (1) or destination (9) cells.

    4. Terminate When Reaching Destination:
           The first time we reach 9, return the distance.
 */

import java.util.LinkedList;
import java.util.Queue;

public class AmazonQuestion {
    public static void main(String[] args) {
        int[][] area = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 9, 1}
        };
        System.out.println(minDistanceToDeliver(area));
    }

    private static int minDistanceToDeliver(int[][] area) {
        int rows = area.length;
        int cols = area[0].length;

        int[][] directions= {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0,0});

        boolean[][] visited = new boolean[rows][cols];

        visited[0][0] = true;

        while (!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0], y = current[1], distance = current[2];

            if (area[x][y] == 9){
                return distance;
            }

            for(int[] dir : directions){
                int rowX = x + dir[0], colY = y + dir[1];

                if (rowX >= 0 && rowX < rows && colY >= 0 && colY < cols && area[rowX][colY] != 0 && !visited[rowX][colY]){
                    q.offer(new int[]{rowX,colY,distance+1});
                    visited[rowX][colY] = true;
                }
            }
        }

        // Exit the loop , no path was found
        return -1;
    }
}