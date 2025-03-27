package SolvingArray.medium.SticklerThief;

/*
    Stickler Thief
        Stickler the thief wants to loot money from a society having n houses in a single line.
        He is a weird person and follows a certain rule when looting the houses.
        According to the rule, he will never loot two consecutive houses. At the same time,
        he wants to maximize the amount he loots. The thief knows which house has what amount of
        money but is unable to come up with an optimal looting strategy. He asks for your help to find the
        maximum money he can get if he strictly follows the rule. ith house has arr[i] amount of money present in it.

        Examples:

        Input: arr[] = [6, 5, 5, 7, 4]
        Output: 15
        Explanation: Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6+5+4=15.


        Input: arr[] = [1, 5, 3]
        Output: 5
        Explanation: Loot only 2nd house and get maximum amount of 5.


        Input: arr[] = [4, 4, 4, 4]
        Output: 8
        Explanation: The optimal choice is to loot every alternate house. Looting the 1st and 3rd houses,
         or the 2nd and 4th, both give a maximum total of 4 + 4 = 8.


    https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */

public class SticklerThief {
    public static void main(String[] args) {
        int[] arr = {6, 5, 5, 7, 4};
        System.out.println(findMaxSum(arr));
    }

    private static int findMaxSum(int[] arr) {
        int size = arr.length;

        int[] dp = new int[size+1];

        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 2; i <= size; i++) {
            dp[i] = Math.max(arr[i-1] + dp[i-2], dp[i-1]);
        }

        return dp[size];
    }
}
