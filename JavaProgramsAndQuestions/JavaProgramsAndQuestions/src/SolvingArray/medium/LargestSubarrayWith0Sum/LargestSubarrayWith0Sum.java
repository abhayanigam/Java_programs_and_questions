package SolvingArray.medium.LargestSubarrayWith0Sum;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }

    private static int maxLen(int[] arr) {
        int maxValue = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentValue = 0;

            for (int j = i; j < arr.length; j++) {
                currentValue +=arr[j];

                if (currentValue == 0){
                    maxValue = Math.max(maxValue,j-i+1);
                }
            }
        }

        return maxValue;
    }
}
