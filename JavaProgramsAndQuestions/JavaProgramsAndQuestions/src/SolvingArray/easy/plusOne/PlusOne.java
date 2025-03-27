package SolvingArray.easy.plusOne;

public class PlusOne {
    public static void main(String[] args) {
//        int[] digits = {1,2,3};
//        int[] digits = {1,5,9};
        int[] digits = {9,9};

        int[] result = plusOne(digits);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static  int[] plusOne(int[] digits) {
        int r;

        int sum = digits[digits.length-1] + 1;
        System.out.println("The value of sum is : " + sum);

        if (sum >= 10){
            int[] arr1 = new int[digits.length+1];

            for (int k = 0; k < digits.length-1; k++) {
                arr1[k] = digits[k];
            }

            while (sum != 0){
                r = sum % 10;
                arr1[(digits.length-1)] = r;
                sum /= 10;
            }

            return arr1;
        }else{
            int[] arr2 = new int[digits.length];

            for (int k = 0; k < digits.length-1; k++) {
                arr2[k] = digits[k];
            }

            arr2[arr2.length-1] = sum;

            return  arr2;
        }
    }
}
