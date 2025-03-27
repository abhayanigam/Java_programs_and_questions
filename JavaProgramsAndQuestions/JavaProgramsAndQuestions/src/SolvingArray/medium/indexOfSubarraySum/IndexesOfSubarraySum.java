package SolvingArray.medium.indexOfSubarraySum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndexesOfSubarraySum {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 7, 5};
//        int target = 12;

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;

        int[] result = findSubarraySum(arr, target);

        System.out.println("Subarray found at indexes : " + Arrays.toString(result));
    }

    private static int[] findSubarraySum(int[] arr, int target) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i<arr.length; i++){
            sum += arr[i];

            if (sum == target){
                return new int[]{1,i+1};
            }

            if (prefixMap.containsKey(sum - target)){
                int startIndex = prefixMap.get(sum- target);
                return new int[]{startIndex + 2, i+1};
            }

            if(!prefixMap.containsKey(sum)){
                prefixMap.put(sum,i);
            }
        }

        return new int[]{-1};
    }
}
