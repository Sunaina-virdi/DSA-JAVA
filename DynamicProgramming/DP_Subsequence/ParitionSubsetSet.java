package DynamicProgramming.DP_Subsequence;
// https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
public class ParitionSubsetSet {
    public static boolean solve(int idx,int target,int[] arr,Boolean[][] dp,int n){
		if(idx == n) return false;
		if(target == 0) return true;
		if(dp[idx][target] != null) return false;

		boolean take = false;
		if(arr[idx] <= target){
			take = solve(idx + 1,target - arr[idx],arr,dp,n);
		}
		boolean skip = solve(idx + 1,target,arr,dp,n);

		return dp[idx][target] = take || skip;
	}
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		int sum = 0;
		for(int i : arr){
			sum += i;
		}
		if(sum % 2 != 0) return false;
		int target = sum / 2;
		Boolean dp[][] = new Boolean[n+1][target+1];
		return solve(0,target,arr,dp,n);
	}
    public static void main(String[] args) {
        int n = 6;
        int arr[] = {3,1,1,2,2,3};
        System.out.println(canPartition(arr, n));
    }
}
