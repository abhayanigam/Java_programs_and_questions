package SolvingArray.kadanes_methods;

public class KadanesImpl {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum is: " + maxSubArrayUsingKadanesAlgo(arr));
        System.out.println("Maximum subarray sum is: " + maxSubArrayUsingPrefixSumAlgo(arr));
    }

    // PrefixSum Algo
    /*
    * Formula :
    *   1. prefix[0] = arr[0];
    *   2. for( i = 1 to size){
    *           sum = prefix[i-1] + arr[i]
    *       }
    *
    * For fast sub array or multiple query in a given range in subArray formula:
    *
    *    sum(l,r) = prefixSum(r) - prefixSum(l-1);
    *
    *   if(l == 0){
    *       sum = prfixSum(r)
    *   }else{
    *       sum = prefixSum(r) - prefixSum(l-1);
    *   }
    * */

    // Time Complexity --> O(n)
    // Space Complexity --> O(n)
    private static int maxSubArrayUsingPrefixSumAlgo(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for(int i = 1; i<arr.length; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int maxSum = prefixSum[0];
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - currentSum);
            currentSum = Math.min(currentSum, prefixSum[i]);
        }

        return maxSum;
    }

    // Kadane's algo
    // Time complexity --> O(n)
    // Space complexity --> O(1)
    private static int maxSubArrayUsingKadanesAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum > maxSum){
                maxSum = currentSum;
            }

            if (currentSum < 0){
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
