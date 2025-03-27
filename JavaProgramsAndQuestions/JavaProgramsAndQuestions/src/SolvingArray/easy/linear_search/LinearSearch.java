package SolvingArray.easy.linear_search;

import java.util.function.Predicate;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 100;

        Predicate<Integer> predicate = search(arr, x);
        System.out.println("The element fount :" + predicate.test(x));
    }

    private static  Predicate<Integer>  search(int[] arr, int x) {
        return (element) ->{
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x){
                    return true;
                }
            }
            return false;
        };
    }
}
