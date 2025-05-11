package DynamicProgramming;
import java.util.* ;
public class Frog_jump {
// Recursion solution - TLE
/* 
    static int solve(int idx, int heights[]){
        if(idx == 0) return 0;

        int left = solve(idx - 1,heights) + Math.abs(heights[idx-1] - heights[idx]);
        int right = Integer.MAX_VALUE;
        if(idx > 1){
            right = solve(idx - 2, heights) + Math.abs(heights[idx-2] - heights[idx]);
        }
        return Math.min(left,right);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        return solve(n-1,heights);
    }
*/

// Dynamic Programming solution
    static int solve(int idx, int heights[],int dp[]){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int skip = solve(idx - 1,heights,dp) + Math.abs(heights[idx-1] - heights[idx]);
        int take = Integer.MAX_VALUE;
        if(idx > 1){
            take = solve(idx - 2, heights,dp) + Math.abs(heights[idx-2] - heights[idx]);
        }
        return dp[idx] = Math.min(skip,take);
    }
    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n-1,heights,dp);
    }

// Space optimization
/*
    public static int frogJump(int n, int heights[]) {
        int prev = 0,prev2 = 0;
        for(int i=1;i<n;i++){
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
            int curr = Math.min(left,right);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.print(frogJump(n, heights));
    }
}



    

