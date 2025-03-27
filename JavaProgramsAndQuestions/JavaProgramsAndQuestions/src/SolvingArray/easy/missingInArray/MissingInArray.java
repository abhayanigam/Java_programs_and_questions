package SolvingArray.easy.missingInArray;

import java.util.HashSet;

public class MissingInArray {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,5};
        int[] arr = {8, 2, 4, 5, 3, 7, 1};

        System.out.println("The missing number in an array is :" + findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr){
            set.add(num);
        }

        for (int i = 1; i <=arr.length+1; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

}
