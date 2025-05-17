package DynamicProgramming.DP_Subsequence;

import java.util.Arrays;

public class PartitionWithDiffK {
     static int mod = (int)(1e9 + 7);
	public static int memo(int idx,int tar,int arr[],int dp[][]){
		if(idx == 0){
			if(tar == 0 && arr[0] == 0) return 2;
			if(tar == 0 || tar == arr[0]) return 1;
			return 0;
		}
		if(dp[idx][tar] != -1) return dp[idx][tar];
		int skip = memo(idx-1,tar,arr,dp);
		int take = 0;
		if(arr[idx] <= tar){
			take = memo(idx-1,tar-arr[idx],arr,dp);
		}
		return dp[idx][tar] = (skip + take)% mod;
	}
	public static int solve(int arr[],int tar){
		int n = arr.length;
		int dp[][] = new int[n][tar+1];
		for(int i[]:dp){
			Arrays.fill(i,-1);
		}
		return memo(n-1,tar,arr,dp);
	}
	public static int countPartitions(int[] arr,int d) {
		// Write your code here.
		int totalSum = 0;
		for(int i : arr){
			totalSum += i;
		}
		if(totalSum - d < 0 || (totalSum -d) % 2 != 0) return 0;
		return solve(arr,(totalSum - d )/ 2);
    }
    public static void main(String[] args) {
        int d = 0;
        int arr[] = {1,1,1,1};
        System.out.println(countPartitions(arr, d));
    }
}
