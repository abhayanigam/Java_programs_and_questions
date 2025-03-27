package SolvingArray.medium.calculatePowerUsingRecursion;

public class CalculatePowerUsingRecursion {
    public static void main(String[] args) {
        int a = 3, b = 2;
        System.out.println("The power of the given number is : " + findPowerUsingRecursion(a,b));
    }

    private static int findPowerUsingRecursion(int a, int b) {
        if (b == 0){
            return 1;
        }
        if (b == 1){
            return a;
        }

        int ans = findPowerUsingRecursion(a,b/2);

        if (b%2 == 0){
            return ans * ans;
        }else{
            return a * (ans * ans);
        }
    }
}
