package SolvingArray.easy.largets_third_element;

public class Largest_Third_Element {
    public static void main(String[] args) {
        int arr[] = {12, 13, 1,10, 34, 16};
        int ans = thirdLargestElement(arr);

        System.out.println("The third largest element is " + ans);
    }

    private static int thirdLargestElement(int[] arr) {
        int first = arr[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first){
                first = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > second && arr[i] < first){
                second = arr[i];
            }
        }

        for (int i = 0; i <arr.length; i++) {
            if (arr[i] > third && arr[i] < second){
                third = arr[i];
            }
        }
        return third;
    }
}
