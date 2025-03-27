package SolvingString.palindrome_string;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the string to check palindrome : ");
        String str = input.nextLine();

        boolean ans = getStringPalindrome(str);

        if (ans){
            System.out.println("The String is a palindrome");
        } else {
            System.out.println("The String is not a palindrome");
        }

        input.close();
    }

    private static boolean getStringPalindrome(String str) {
        str = str.toLowerCase();

        String rev = "";
        for (int i = str.length()-1; i >= 0 ; i--) {
            rev += str.charAt(i);
        }

        System.out.println("The Reverse string is : " + rev);

        return str.equals(rev);
    }
}
