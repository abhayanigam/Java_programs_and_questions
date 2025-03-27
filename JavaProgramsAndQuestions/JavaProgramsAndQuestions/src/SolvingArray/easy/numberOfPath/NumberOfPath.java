package SolvingArray.easy.numberOfPath;

public class NumberOfPath {
    public static void main(String[] args) {
//        int m = 3;
        int m = 2;
        int n = 3;
        int result = numberOfPath(m,n);

        System.out.println("The number of path is : " + result);
    }

//    Using Recursion – O(2^(n+m)) Time and O(n+m) Space
    private static int numberOfPath(int m, int n) {
        if (m == 1 || n == 1){
            return 1;
        }

        return numberOfPath(m-1,n) + numberOfPath(m,n-1);
    }
}
