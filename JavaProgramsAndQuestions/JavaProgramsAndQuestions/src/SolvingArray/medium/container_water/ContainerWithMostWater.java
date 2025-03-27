package SolvingArray.medium.container_water;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + solution.maxAreaMethod1(heights));
        System.out.println("Max area: " + solution.maxAreaMethod2(heights));
        System.out.println("Max area: " + solution1(heights));
    }

    static int solution1(int[] heights) {
        return 10;
    }
}

class Solution {
    // Time Complexity is O(n)
    public int maxAreaMethod1(int[] height) {

        int area = 0;
        int width= 0;
        int minHeight = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                width = j-i;
                minHeight = min(height[j],height[i]);
                area = max(area,minHeight*width);
            }
        }

        return  area;
    }

    public int maxAreaMethod2(int[] heights) {
        int area = 0 , left = 0, right = heights.length-1;

        while (left < right){
            area = max(area, min(heights[left], heights[right]) * (right - left));

            if (heights[left] < heights[right]){
                left++;
            }else {
                right--;
            }
        }

        return area;
    }
}