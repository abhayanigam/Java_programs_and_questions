package SolvingArray.easy.find_triplets_equal_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindingTriplets {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,4,5,6));

        System.out.println("The sum of the triplets is : " + getTripletsSum(arr, 90));

        //By using predicate
        Predicate<ArrayList<Integer>> hasTripletSum = getArrayListPredicate(9);

        System.out.println("Finding triplets using predicate : " +  hasTripletSum.test(arr));

        input.close();
    }

    private static Predicate<ArrayList<Integer>> getArrayListPredicate(int sum) {
        Predicate<ArrayList<Integer>> hasTripletSum = (list) -> {
            for (int i = 0; i < list.size()-2; i++) {
                for (int j = i+1; j < list.size()-1; j++) {
                    for (int k = j+1; k < list.size(); k++) {
                        if (list.get(i) + list.get(j) + list.get(k) == sum){
                            return true;
                        }
                    }
                }
            }

            return false;
        };
        return hasTripletSum;
    }

    private static boolean getTripletsSum(ArrayList<Integer> arr, int sum) {
        for (int i = 0; i < arr.size()-2; i++) {
            for (int j = i+1; j < arr.size()-1; j++) {
                for (int k = j+1; k < arr.size(); k++) {
                    if (arr.get(i) + arr.get(j) + arr.get(k) == sum){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
