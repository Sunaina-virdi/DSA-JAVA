package DynamicProgramming;
// leetcpde - 198
import java.util.ArrayList;
import java.util.Arrays;

public class NonAdajSum {
// MEMOIZATION
// TC - O(N) 
// SC - O(N) + O(N)
    public static int solve(int idx,ArrayList<Integer>nums,int dp[]){
		if(idx == 0) return nums.get(idx);
		if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

		int pick = nums.get(idx) + solve(idx-2,nums,dp);
		int skip = 0 + solve(idx-1,nums,dp);

		return dp[idx] = Math.max(pick , skip);
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		// TC - O(N)
		// SC - O(N) + O(N)
		int n = nums.size();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
		return solve(n-1,nums,dp);
	}

// TABULATION 
// TC - O(N)
// SC - O(N)
    public static int tabulation(ArrayList<Integer> nums){
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums.get(0);

        int dp[] = new int[n+1];
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0),nums.get(1));

        for(int i=2;i<nums.size();i++){
            int take = nums.get(i) + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(take,skip);
        }
        return dp[n - 1];
    }

// SPACE OPTIMIZATION
    public static int optimize(ArrayList<Integer>nums){
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums.get(0);

        int prev = Math.max(nums.get(0),nums.get(1));
        int prev2 = nums.get(0);

        for(int i = 2;i < n; i++){
            int take = nums.get(i) + prev2;
            int skip = prev;
            int curr = Math.max(take,skip);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        System.out.println(maximumNonAdjacentSum(nums));
        System.out.println(tabulation(nums));
        System.out.println(optimize(nums));
    }
}
