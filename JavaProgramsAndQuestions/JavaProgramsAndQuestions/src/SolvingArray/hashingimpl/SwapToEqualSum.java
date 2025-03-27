package SolvingArray.hashingimpl;

/*
    Given two arrays of integers, find a pair of values (one value from each array) that you can swap to
    give the two arrays the same sum.

    Examples:

    Input: A[] = {4, 1, 2, 1, 1, 2}, B[] = (3, 6, 3, 3)
    Output: 1 3
    Explanation: Sum of elements in A[] = 11 and Sum of elements in B[] = 15.
    To get same sum from both arrays, we can swap 1 from A[] with 3 from B[].


    Input: A[] = {5, 7, 4, 6}, B[] = {1, 2, 3, 8}
    Output: 6 2
    Explanation: Sum of elements in A[] = 22 and Sum of elements in B[] = 14.
    To get same sum from both arrays, we can swap 6 from A[] and 2 from B[].


 */

import java.util.Arrays;

public class SwapToEqualSum {
    public static void main(String[] args) {
        int[] A1 = {4, 1, 2, 1, 1, 2};
        int[] B1 = {3, 6, 3, 3};
        int[] result1 = findSwapValues(A1, B1);
        if (result1 != null) {
            System.out.println(result1[0] + " " + result1[1]);
        } else {
            System.out.println("No swap possible");
        }

        int[] A2 = {5, 7, 4, 6};
        int[] B2 = {1, 2, 3, 8};
        int[] result2 = findSwapValues(A2, B2);
        if (result2 != null) {
            System.out.println(result2[0] + " " + result2[1]);
        } else {
            System.out.println("No swap possible");
        }
    }

    private static int[] findSwapValues(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        // If the difference is odd, return null (no valid integer swaps)
        if ((sumA - sumB) % 2 != 0) return null;

        int diff = (sumA - sumB) / 2;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int currentDiff = A[i] - B[j];

            if (currentDiff == diff) {
                return new int[]{A[i], B[j]}; // Found the first correct swap pair
            } else if (currentDiff < diff) {
                i++; // Increase A[i] to get a larger difference
            } else {
                j++; // Increase B[j] to get a smaller difference
            }
        }
        return null; // No valid pair found
    }
}
