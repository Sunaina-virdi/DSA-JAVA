package DynamicProgramming;

import java.util.Arrays;

public class nStairs {
    // recursive solution - TLE
    public static long countDistinctWayToClimbStair(int nStairs) {
		// Write your code here.
		if(nStairs == 0 || nStairs == 1) return 1;

		long left = countDistinctWayToClimbStair(nStairs-1);
		long right = countDistinctWayToClimbStair(nStairs-2);
		return left + right;
	}

    // MEMOIZATION
    public static long solve(int idx, long dp[]) {
        if (idx == 0 || idx == 1) return 1;

        if (dp[idx] != -1) return dp[idx];

        long left = solve(idx - 1, dp);
        long right = solve(idx - 2, dp);
        return dp[idx] = left + right;
    }

    public static long countDistinctWayToClimbStair2(int nStairs) {
        long[] dp = new long[nStairs + 1];
        Arrays.fill(dp, -1); // ✅ Proper initialization
        return solve(nStairs, dp);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.print(countDistinctWayToClimbStair(n));
    }
}
