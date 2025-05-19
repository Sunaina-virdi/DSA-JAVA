package DynamicProgramming.DP_2D;

public class KnapSack0_1 {
    static int rec(int W,int val[],int wt[],int n){
        if(n == 0 || W == 0) return 0;
        if(wt[n-1] <= W){
            return Math.max((val[n-1] + rec(W-wt[n-1],val,wt,n-1)),
                        rec(W,val,wt,n-1));
        }
        else{
            return rec(W,val,wt,n-1);
        }
    }
    // memo
    static int memo(int W,int val[],int wt[],int n,int[][]dp){
        if(n == 0 || W == 0) return 0;
        if(dp[n][W] != -1) return dp[n][W];
        if(wt[n-1] <= W){
            return dp[n][W] = Math.max((val[n-1] + memo(W-wt[n-1],val,wt,n-1,dp)),
                        memo(W,val,wt,n-1,dp));
        }
        else{
            return dp[n][W] = memo(W,val,wt,n-1,dp);
        }
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][]dp = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
           for(int j = 0;j < W+1; j++){
               dp[i][j] = -1;
           }
        }
        // return rec(W,val,wt,n);
        return memo(W,val,wt,n,dp);
    }
    public static void main(String[] args) {
        int W = 3;
        int val[] = {1,2,3};
        int wt[] = {4,5,6};
        System.out.println(knapsack(W, val, wt));
    }
}
