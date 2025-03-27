package SolvingArray.easy.two_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum{
    public static void main(String[] args){
        int[] nums = {2,7,11,15};

        int target = 9;

        List<Integer> list = solution(nums, target);

        System.out.println("The indexes are : " + list);

        int[] nums1 = {3,2,4};

        int target1 = 6;

        List<Integer> list1 = solution(nums1, target1);

        System.out.println("The indexes are : " + list1);

        // Do the question using list of list
        List<List<Integer>> result = solution2(nums, target);

        for (List<Integer> pair : result) {
            System.out.println("The result is : " + pair);
        }

        // Solution 2 using while loop
        List<Integer> ans = solution3(nums, target);
        System.out.println("The ans using while loop is : " + ans);

        // Solution 3 using array
        int[] arr = solution4(nums, target);
        System.out.println("The ans using array : " + Arrays.toString(arr));
    }

    private static int[] solution4(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    private static List<Integer> solution3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        List<Integer> list = new ArrayList<>();

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                list.add(left);
                list.add(right);
                return list;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return list;
    }

    private static List<List<Integer>> solution2(int[] nums, int target) {
        List<List<Integer>> pair = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);

                    pair.add(list);
                    return pair;
                }
            }
        }

        return pair;
    }

    private static List<Integer> solution(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        for (int i= 0; i<nums.length; i++){
            for (int j = i+1; j  < nums.length; j++) {
                if (nums[j] + nums[i] == target){
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
    }
}
