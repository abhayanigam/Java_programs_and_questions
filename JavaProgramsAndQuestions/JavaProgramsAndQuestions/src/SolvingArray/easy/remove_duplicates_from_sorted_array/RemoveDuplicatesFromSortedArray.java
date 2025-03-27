package SolvingArray.easy.remove_duplicates_from_sorted_array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int newNumLength = removeDuplicates(nums);

        for (int i = 0; i < newNumLength; i++) {
            System.out.print(nums[i]+ "");
        }
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0;

        if (nums == null){
            return  0;
        }

        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
