package DynamicProgramming;

import java.util.Scanner;

public class FrogJumpksteps {
// TC - O(N) * K
// SC - O(N) + O(N)
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.print(frogJump(n-1,n, heights));
    }
}
