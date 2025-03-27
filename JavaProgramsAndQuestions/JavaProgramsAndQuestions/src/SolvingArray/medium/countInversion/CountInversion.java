package SolvingArray.medium.countInversion;

public class CountInversion {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 3, 5};
        int[] arr = {2, 3, 4, 5, 6};

        System.out.println(findInversion(arr));
    }

    private static int findInversion(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
