package DynamicProgramming.DP_2D;

import java.util.Arrays;
// leetcode 188
public class BuyandSellIV {
    // recursive approach
// TC - O(2^n)
// SC - O(n)
    public int rec(int k,int prices[],int idx,int hold){
        if(idx == prices.length) return 0;
        int profit = 0;
        if(k == 0) return profit;

        if(hold == 1){
            int sell = prices[idx] + rec(k-1,prices,idx+1,0);
            int skipsell = rec(k,prices,idx+1,1);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + rec(k,prices,idx+1,1);
            int skipbuy = rec(k,prices,idx+1,0);
            profit = Math.max(buy,skipbuy);
        }
        return profit;
    }
// Memoization approach
// TC - O(nk)
// SC - O(nk)
    public int memo(int k,int prices[],int idx,int hold,int dp[][][]){
        if(idx == prices.length || k==0) return 0;
        if(dp[idx][hold][k] != -1) return dp[idx][hold][k];

        int profit = 0;

        if(hold == 1){
            int sell = prices[idx] + memo(k-1,prices,idx+1,0,dp);
            int skipsell = memo(k,prices,idx+1,1,dp);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + memo(k,prices,idx+1,1,dp);
            int skipbuy = memo(k,prices,idx+1,0,dp);
            profit = Math.max(buy,skipbuy);
        }
        return dp[idx][hold][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int[][] i : dp){
            for(int[] j : i){
                Arrays.fill(j, - 1);
            }
        }
        return memo(k,prices,0,0,dp);
        
        // return rec(k,prices,0,0);
    }
}
