package SolvingArray.easy.maximum_consecutive_number;

import java.util.ArrayList;

public class Maximum_Consecutive_Number {
    public static void main(String[] args) {
        int[] arr =  {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1,1};
        int ans = maxConsecutiveNumber(arr);
    }

    private static int maxConsecutiveNumber(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i<= arr.length-1; i++){
            if(arr[i]== 1){
                list1.add(arr[i]);
            }else{
                if (result.isEmpty()){
                    result.addAll(list1);
                }else {
                    if (result.size() < list1.size()){
                        result.clear();
                        result.addAll(list1);
                    }else{
                        list1.clear();
                    }
                }
            }
        }

        System.out.println("The List length of 1s is : ");
        for (int ans : result) {
            System.out.print(ans + " ");
        }
        return 0;
    }
}
