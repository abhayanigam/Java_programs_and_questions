package SolvingArray.easy.countTripletThridElement;

import java.util.HashSet;

public class CountTripletThirdElement {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 2};
//        int[] arr = {2, 3, 4};

        System.out.println(findTripletUsingThreeLoop(arr));
        System.out.println(findTripletUsingHashSet(arr));
    }

    private static int findTripletUsingHashSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr){
            set.add(num);
        }

        int count = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr.length; j++){ // for (int j = i+1; j<arr.length; j++){
                if (i != j){
                    int sum = arr[i] + arr[j];

                    if (set.contains(sum)){
                        count++;
                    }
                }
            }
        }

        return count/2; //return count in case of int j = i+1; j<arr.length; j++)
    }



    //Time complexity is O(n^3)
    private static int findTripletUsingThreeLoop(int[] arr) {
        int size = arr.length;
        
        for (int i = 0; i<size-2;i++){
            for (int j = i+1; j < size-1; j++) {
                for (int k = 0; k < size; k++) {
                    if (arr[i] + arr[j] == arr[k] || arr[i] + arr[j] == arr[k] || arr[j] + arr[k] == arr[i]){
                        int[] ints = {arr[i], arr[j]};
                        return ints.length;
                    }
                }
            }
        }
        return 0;
    }
}
