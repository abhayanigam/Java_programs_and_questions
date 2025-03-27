package SolvingArray.medium.ZigZagfashion;

import java.util.Arrays;

public class ZigZagFashion {
    public static void main(String[] args) {
        int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
        zigZag(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void zigZag(int[] arr) {
        boolean flag = true;

        int temp = 0;

        for (int i = 0; i <= arr.length-2; i++) {
            if (flag){
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }else{
                if (arr[i] < arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }

            flag = !flag;
        }
    }
}
