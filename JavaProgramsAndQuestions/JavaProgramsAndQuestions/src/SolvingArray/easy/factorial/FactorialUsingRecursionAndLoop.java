package SolvingArray.easy.factorial;

import java.util.Scanner;

public class FactorialUsingRecursionAndLoop {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to calculate SolvingArray.factorial : ");
        int number = input.nextInt();

        System.out.println("The SolvingArray.factorial of a number is : " + getFactorialUsingLoop(number));

        System.out.println("The SolvingArray.factorial of a number is : " + getFactorialUsingRecursion(number));

        input.close();
    }

    private static int getFactorialUsingRecursion(int number) {
        if (number > 0){
            return (number*getFactorialUsingRecursion(number-1));
        }else{
            return 1;
        }
    }

    private static int getFactorialUsingLoop(int number) {
        int fact = 1;
        if (number > 0){
            for (int i = 1; i <=number ; i++) {
                fact*=i;
            }
        }else {
            return 1;
        }
        return fact;
    }
}
