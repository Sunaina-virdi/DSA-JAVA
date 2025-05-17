package DynamicProgramming.DP_Subsequence;

import java.util.Arrays;
// leetcode 322
public class CoinChange {
    // recursion method
    public int rec(int[] coins,int amount,int idx){
        if(idx < 0)return (int)(1e9);
        if(amount == 0) return 0;

        int take = (int)(1e9);
        if(coins[idx] <= amount){
            take = 1 + rec(coins,amount-coins[idx],idx);
        }
        int skip = rec(coins,amount,idx-1);
        return Math.min(take,skip);
    }

// memo method
    public int solve(int[] coins,int amount,int idx,int[][]dp){
        if(idx < 0)return (int)(1e9);
        if(amount == 0) return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = (int)(1e9);
        if(coins[idx] <= amount){
            take = 1 + solve(coins,amount-coins[idx],idx,dp);
        }
        int skip = solve(coins,amount,idx-1,dp);
        return dp[idx][amount] = Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // Arrays.sort(coins);
        // int ans = rec(coins,amount,n-1);

        int dp[][] = new int[n][amount+1];
        for(int i[] : dp) Arrays.fill(i,-1);

        int ans = solve(coins,amount,n-1,dp);
        if(ans == (int)(1e9)) return -1;
        else return ans;    
    }
}
