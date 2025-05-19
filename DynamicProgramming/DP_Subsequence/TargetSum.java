package DynamicProgramming.DP_Subsequence;
import java.util.Arrays;
// leetcode 494
public class TargetSum {
    public static int solve(int nums[],int idx,int k,int dp[][]){
        if(idx == 0){
            if(k == 0 && nums[0] == 0) return 2;
            if(k == 0 || nums[0] == k) return 1;     
            return 0;
        }
        if(dp[idx][k] != -1) return dp[idx][k];

        int skip = solve(nums,idx-1,k,dp);
        int take = 0;
        if(nums[idx] <=  k){
            take = solve(nums,idx-1,k-nums[idx],dp);
        }
        return dp[idx][k] = take + skip;
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int i : nums){
            totalSum += i;
        }
        if((totalSum - target < 0) || ((totalSum - target) % 2 != 0)) return 0;
        int k = (totalSum - target) / 2;
        int [][]dp = new int[n][k+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(nums,n-1,k,dp);
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
