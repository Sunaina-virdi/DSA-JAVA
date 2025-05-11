package DynamicProgramming;

import java.util.Arrays;

// leetcode 714
public class BuyandSellFee {
    // recursion approach
    public int rec(int[] prices,int idx,int hold,int fee){
        if(idx >= prices.length) return 0;

        int profit = 0;
        if(hold == 1){
            int sell = prices[idx] + rec(prices,idx+1,0,fee) - fee;
            int skipsell = rec(prices,idx+1,1,fee);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + rec(prices,idx+1,1,fee);
            int skipbuy = rec(prices,idx+1,0,fee);
            profit = Math.max(buy,skipbuy);
        }
        return profit;
    }
// Memoization approach
    public int memo(int[] prices,int idx,int hold,int fee,int[][]dp){
        if(idx >= prices.length) return 0;
        if(dp[idx][hold] != -1) return dp[idx][hold];

        int profit = 0;
        if(hold == 1){
            int sell = prices[idx] + memo(prices,idx+1,0,fee,dp) - fee;
            int skipsell = memo(prices,idx+1,1,fee,dp);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + memo(prices,idx+1,1,fee,dp);
            int skipbuy = memo(prices,idx+1,0,fee,dp);
            profit = Math.max(buy,skipbuy);
        }
        return dp[idx][hold] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        // return rec(prices,0,0,fee);

        int[][] dp = new int[prices.length][2];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return memo(prices,0,0,fee,dp);
    }
}
