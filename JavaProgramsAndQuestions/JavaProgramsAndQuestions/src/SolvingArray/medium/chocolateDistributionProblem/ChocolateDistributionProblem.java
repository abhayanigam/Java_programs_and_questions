package SolvingArray.medium.chocolateDistributionProblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50));

        int m = 7;

        int result = chocolateDistribution(arr,m);

        if (result != -1){
            System.out.println("Minimum difference is : " + result);
        }else{
            System.out.println("Invalid input");
        }
    }

    private static int chocolateDistribution(List<Integer> arr, int m) {
        if(arr.size() == 0 || m == 0){
            return 0;
        }

        if (arr.size() - 1 < m){
            return -1;
        }

        Collections.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i<arr.size(); i++){
            int nxtWindow = i + m-1;

            if (nxtWindow >= arr.size()){
                break;
            }

            int diff = arr.get(nxtWindow) - arr.get(i);

            minDiff = Math.min(minDiff,diff);
        }

        return minDiff;
    }
}
