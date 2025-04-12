package Recursion;

public class nStairs {
    // recursive solution - TLE
    public static long countDistinctWayToClimbStair(int nStairs) {
        // Write your code here.
        if(nStairs == 0 || nStairs == 1) return 1;

        long left = countDistinctWayToClimbStair(nStairs-1);
        long right = countDistinctWayToClimbStair(nStairs-2);
        return left + right;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.print(countDistinctWayToClimbStair(n));
    }
}
    
