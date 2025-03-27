package SolvingArray.easy.three_sum;


import java.util.*;

public class Three_Sum {
        public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = solution.getThreeSum(nums);

        for (List<Integer> l : list) {
            System.out.println(l);
        }


    }
}

class Solution{
    public List<List<Integer>> getThreeSum(int[] nums){
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list); // Sort the triplet to avoid permutation duplicates
                        set.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}