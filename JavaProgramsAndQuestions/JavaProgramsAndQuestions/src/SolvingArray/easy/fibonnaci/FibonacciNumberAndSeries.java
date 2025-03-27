package SolvingArray.easy.fibonnaci;

import java.util.Scanner;

public class FibonacciNumberAndSeries {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number to print SolvingArray.fibonacci : ");
        int number = input.nextInt();

        for (int i = 0; i <= number; i++) {
            System.out.print(" " + fibonacciNumber(i));
        }
        System.out.println();

        System.out.println("The SolvingArray.fibonacci Number is : " + fibonacciNumber(number));

        input.close();
    }

    private static int fibonacciNumber(int number) {
        if (number == 0 || number == 1){
            return number;
        }else{
            return (fibonacciNumber(number-1) + fibonacciNumber(number - 2));
        }
    }
}
