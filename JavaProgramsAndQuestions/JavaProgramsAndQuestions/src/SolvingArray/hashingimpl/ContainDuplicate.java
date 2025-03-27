package SolvingArray.hashingimpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};

        System.out.println("The array contains the duplicate value : " + hasDuplicate_Method1(nums));
        System.out.println("The array contains the duplicate value : " + hasDuplicate_Method2(nums));
        System.out.println("The array contains the duplicate value : " + hasDuplicate_Method3(nums));
        System.out.println("The array contains the duplicate value : " + hasDuplicate_Method4(nums));
    }

    // Brute Force O(n^2)
    private static boolean hasDuplicate_Method1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length; j++) {
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }

        return false;
    }

    // Sorting O(n log n)
    private static boolean hasDuplicate_Method2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
    
    // HashSet O(n)
    private static boolean hasDuplicate_Method3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)){
                System.out.println(nums[i]);
                return true;
            }
            set.add(i);
        }
        return false;
    }

    // HashSet Length O(n)
    private static boolean hasDuplicate_Method4(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

}
