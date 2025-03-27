package SolvingArray.easy.leaders_array;

import java.util.ArrayList;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };

        ArrayList<Integer> list = leaders(arr);

        for (int result : list) {
            System.out.print(result + " ");
        }
    }

    private static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int j;

            for (j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[i]){
                    break;
                }
            }

            if(j == arr.length){
                result.add(arr[i]);
            }
        }
        return result;
    }
}
