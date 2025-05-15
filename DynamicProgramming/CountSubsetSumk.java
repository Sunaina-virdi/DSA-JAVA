package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetSumk {
    // recursion 
    // TC - (2^n)
    // SC - O(N)
    public static int solve(int num[],int idx,int tar){
        if(tar == 0) return 1;
        if(idx == 0) return num[0] == tar ? 1 : 0;
        // if(idx < 0 || tar < 0) return 0;
        
        int exclude = solve(num,idx-1,tar);
        int include = 0;
        if(num[idx] <= tar){
            include = solve(num,idx-1,tar-num[idx]);
        }
        return include + exclude;
    }
    // TC - O(N * tar)
    // SC - O(N * tar) + O(N)
    public static int memo(int num[],int idx,int tar,int dp[][]){
        // if(tar == 0) return 1;
        if (idx == 0) {
            if(tar == 0 && num[0] == 0) return 2;
            if(tar == 0 || tar == num[0]) return 1;
            return 0;
        }
        if(dp[idx][tar] != -1) return dp[idx][tar];
        
        int exclude = memo(num,idx-1,tar,dp);
        int include = 0;
        if(num[idx] <= tar){
            include = memo(num,idx-1,tar-num[idx],dp);
        }
        return dp[idx][tar] = (include + exclude) % 1000000007;
    }
    public static int findWays(int num[], int tar) {
        int dp[][] = new int[num.length][tar+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return memo(num,num.length - 1,tar,dp);
        // return solve(num,num.length-1,tar);
    }
    public static void main(String[] args) {
        int num[] = {1,1,4,5};
        int tar = 5;
        System.out.println(findWays(num, tar));
    }
}
