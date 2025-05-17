package DynamicProgramming.DP_1D;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpksteps {
// TC - O(N) * K
// SC - O(N) + O(N) -> O(N)
    public static int frogJump(int idx,int k, int heights[]) {
        if(idx == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for(int j = 1;j<=k;j++){
            if(idx - j >= 0){
                int jump = frogJump(idx - j,k,heights) + Math.abs(heights[idx] - heights[idx - j]);
                minSteps = Math.min(minSteps,jump);
            }
        }
        return minSteps;
    }
// TC - O(N)
// SC - O(N)
    public static int frogJumpmemo(int idx,int k, int heights[],int dp[]) {
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int minSteps = Integer.MAX_VALUE;

        for(int j = 1;j<=k;j++){
            if(idx - j >= 0){
                int jump = frogJumpmemo(idx - j,k,heights,dp) + Math.abs(heights[idx] - heights[idx - j]);
                minSteps = Math.min(minSteps,jump);
            }
        }
        return dp[idx] = minSteps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int k = 2;
        int heights[] = {10,5,20,0,15};
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(frogJump(n-1,k, heights));
        System.out.println(frogJumpmemo(n-1, k, heights, dp));
    }
}
