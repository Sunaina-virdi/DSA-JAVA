package DynamicProgramming;

import java.util.Arrays;
// leetcode 123
public class BuyandSellIII {
    // recursion approach
// TC - O(2^n)
// SC - O(n)
    public int rec(int[] prices,int idx,int hold,int max){
        if(idx == prices.length) return 0;
        int profit = 0;
        if(max == 2) return profit;
        if(hold == 1){
            int sell = prices[idx] + rec(prices,idx+1,0,max+1);
            int skipsell = rec(prices,idx+1,1,max);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + rec(prices,idx+1,1,max);
            int skipbuy = rec(prices,idx+1,0,max);
            profit = Math.max(buy,skipbuy);
        }
        return profit;
    }
// memoization approach
// TC - O(n)
// SC - O(n)
    public int memo(int[] prices,int idx,int hold,int max,int dp[][][]){
        if(idx == prices.length) return 0;
        if(dp[idx][hold][max] != -1) return dp[idx][hold][max];

        int profit = 0;
        if(max == 2) return profit;

        if(hold == 1){
            int sell = prices[idx] + memo(prices,idx+1,0,max+1,dp);
            int skipsell = memo(prices,idx+1,1,max,dp);
            profit = Math.max(sell,skipsell);
        }
        else{
            int buy = -prices[idx] + memo(prices,idx+1,1,max,dp);
            int skipbuy = memo(prices,idx+1,0,max,dp);
            profit = Math.max(buy,skipbuy);
        }
        return dp[idx][hold][max] = profit;
    }

    public int maxProfit(int[] prices) {
        // return rec(prices,0,0,0);

        // 2 hold -> hold , not hold
        // 3 max -> No transaction, 1 transaction, 2 transaction
        int[][][] dp = new int[prices.length][2][3];
        
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }

        return memo(prices,0,0,0,dp);
    }
}
