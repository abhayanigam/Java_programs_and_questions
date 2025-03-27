package SolvingArray.easy.prefixSufixSum;

import java.util.Arrays;

public class PrefixSuffixSum {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
        int[] arr = {12, 34, 67, 90};
//        int[] arr = {9, 5, 7, 3};

        int[] prefixSum = computePrefixSum(arr);
        int[] suffixSum = computeSuffixSum(arr);

        System.out.println("Original Array is : " + Arrays.toString(arr));
        System.out.println("PrefixSum Array is : " + Arrays.toString(prefixSum));
        System.out.println("SuffixSum Array is : " + Arrays.toString(suffixSum));
    }

    private static int[] computeSuffixSum(int[] arr) {
        int n = arr.length;
        int[] suffixSum = new int[n];
        int value = 0;

        suffixSum[n-1] = arr[n-1];

        for (int i = n-2; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + arr[i];
        }
//        return suffixSum;

        for (int i = 0; i < n-1; i++) {
            value += arr[i];
        }

        System.out.println("The value of :" + value);

        suffixSum[n-1] = value;

        return Arrays.copyOfRange(suffixSum, 1, n);
    }

    private static int[] computePrefixSum(int[] arr) {
        int n = arr.length;

        int[] prefixSum = new int[n];

        prefixSum[0] = arr[0];

        for (int i = 1; i< arr.length; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        return prefixSum;
    }
}
