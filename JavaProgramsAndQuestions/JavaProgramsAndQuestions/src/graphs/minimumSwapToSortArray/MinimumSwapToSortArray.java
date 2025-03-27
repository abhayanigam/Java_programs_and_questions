package graphs.minimumSwapToSortArray;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapToSortArray {
    public static void main(String[] args) {
        int[] arr = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(arr));
    }

    private static int minSwaps(int[] arr) {
        int[] temp = arr.clone();

        Arrays.sort(temp);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< arr.length; i++){
            map.put(arr[i],i);
        }

        int swaps = 0;

        for (int i = 0; i < arr.length; i++) {
            if (temp[i] != arr[i]){
                int index = map.get(temp[i]);

                int temValue = arr[i];
                arr[i] = arr[index];
                arr[index] = temValue;

                map.put(arr[i],i);
                map.put(arr[index],index);

                swaps++;
            }
        }

        return swaps;
    }
}
