package Greedy;
// Leetcode 45
public class JumpGame {
     public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;

        int far = 0,jumps = 0,currEnd = 0;

        for(int i=0;i<n-1;i++){
            far = Math.max(far,i+nums[i]);

            if(i == currEnd){
                jumps++;
                currEnd = far;
            }
        }
        return jumps;
    }
}
