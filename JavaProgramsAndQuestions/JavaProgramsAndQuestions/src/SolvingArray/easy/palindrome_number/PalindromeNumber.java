package SolvingArray.easy.palindrome_number;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number to check palindrome : ");
        int number = input.nextInt();

        int reverse = getPalindrome(number);

        System.out.println("The reverse number is : " + reverse);

        if (number == reverse){
            System.out.println("The value is a palindrome");
        }else{
            System.out.println("The value is not a palindrome");
        }

        input.close();
    }

    private static int getPalindrome(int number) {
        int value = 0;

        while(number > 0){
            value = value*10 + number % 10;
            number /= 10;
        }

        return value;
    }
}
