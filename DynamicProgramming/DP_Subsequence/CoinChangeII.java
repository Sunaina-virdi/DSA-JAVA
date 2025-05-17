package DynamicProgramming.DP_Subsequence;

import java.util.Arrays;
// leetcode 518
public class CoinChangeII {
    // recursion
    public int rec(int[] coins,int amount,int idx){
        if(idx >= coins.length) return 0;
        if(amount == 0) return 1;

        if(coins[idx] > amount) return rec(coins,amount,idx+1);

        int take = rec(coins,amount - coins[idx],idx);
        int skip = rec(coins,amount,idx+1);
        return take + skip;
    } 
// memo
    public int memo(int[] coins,int amount,int idx,int dp[][]){
        if(idx >= coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        int take = 0;
        if(coins[idx] <= amount)
            take = memo(coins,amount - coins[idx],idx,dp);
        int skip = memo(coins,amount,idx+1,dp);
        return dp[idx][amount] = take + skip;
    }
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        // return rec(coins,amount,0);
        return memo(coins,amount,0,dp);
    }
}
