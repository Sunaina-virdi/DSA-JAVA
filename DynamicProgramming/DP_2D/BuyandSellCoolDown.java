package DynamicProgramming.DP_2D;

import java.util.Arrays;
// leetcode 309
public class BuyandSellCoolDown {
    // Recursion method 
// TC - O(2^n)
// SC - O(n)
    public int rec(int prices[],int idx,int hold){
        if(idx >= prices.length) return 0;
        int profit = 0;
        if(hold == 1){
            int sell = prices[idx] + rec(prices,idx+2,0);
            int skipsell = rec(prices,idx+1,1);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + rec(prices,idx+1,1);
            int skipbuy = rec(prices,idx+1,0);
            profit = Math.max(buy,skipbuy);
        }
        return profit;
    }
// Memoization
// TC - O(n)
// SC - O(n)
    public int memo(int prices[],int idx,int hold,int [][]dp){
        if(idx >= prices.length) return 0;
        if(dp[idx][hold] != -1) return dp[idx][hold];

        int profit = 0;
        
        if(hold == 1){
            int sell = prices[idx] + memo(prices,idx+2,0,dp);
            int skipsell = memo(prices,idx+1,1,dp);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + memo(prices,idx+1,1,dp);
            int skipbuy = memo(prices,idx+1,0,dp);
            profit = Math.max(buy,skipbuy);
        }
        return dp[idx][hold] = profit;
    }
    public int maxProfit(int[] prices) {
        // return rec(prices,0,0);

        int[][] dp = new int[prices.length][2];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return memo(prices,0,0,dp);
    }
}
