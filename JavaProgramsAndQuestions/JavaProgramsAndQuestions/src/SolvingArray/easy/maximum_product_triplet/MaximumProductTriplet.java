package SolvingArray.easy.maximum_product_triplet;

public class MaximumProductTriplet {
    public static void main(String[] args) {
        int[] arr1 = {10,3,5,6,20};

        int ans1 = getMaximumTriplet(arr1);

        System.out.println("The ans is " + ans1);
    }

    private static int getMaximumTriplet(int[] arr) {

        int maxProduct = 0;
        for (int i = 0; i < arr.length -2; i++) {
            for (int j = i+1; j <arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    maxProduct = Math.max(maxProduct, (arr[i] * arr[j] * arr[k]));
                }
            }
        }

        return maxProduct;
    }
}
