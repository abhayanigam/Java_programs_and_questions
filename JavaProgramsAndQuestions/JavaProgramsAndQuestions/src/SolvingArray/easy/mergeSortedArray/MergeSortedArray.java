package SolvingArray.easy.mergeSortedArray;

import java.util.ArrayList;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        int m = 3, n = 3;

        merge(arr1, m, arr2, n);
    }

    private static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(i<m && j<n){
            if (arr1[i] < arr2[j]){
                list.add(arr1[i++]);
            }else {
                list.add(arr2[j++]);
            }
        }

        while(i < m){
            list.add(arr1[i++]);
        }

        while(j < n){
            list.add(arr2[j++]);
        }

        for (int a : list) {
            System.out.println(a);
        }
    }
}
