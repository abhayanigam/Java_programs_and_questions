package SolvingArray.easy.GreatestCommonDivisor;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number a : ");
        int a = input.nextInt();

        System.out.print("Enter the number b : ");
        int b = input.nextInt();

        findGCD(a,b);
        input.close();
    }

    private static void findGCD(int a, int b) {
        if(a == b){
            System.out.println(a);
        } else if ((a % b) == 0) {
            System.out.println(b);
        } else if ((b % a) == 0) {
            System.out.println(a);
        } else if (a > b) {
            findGCD((a % b), b);
        } else if (a < b) {
            findGCD(a, b%a);
        }
    }
}
