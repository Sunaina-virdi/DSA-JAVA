package DynamicProgramming.DP_1D;
// leetcode 213
import java.util.ArrayList;

public class HouseRobberII {
    public static int solve(ArrayList<Integer> nums){
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums.get(0);

        int prev = Math.max(nums.get(0),nums.get(1));
        int prev2 = nums.get(0);

        for(int i=2;i<n;i++){
            int take = nums.get(i) + prev2;
            int skip = prev;
            int curr = Math.max(take,skip);
            prev2 = prev;
            prev = curr;
        } 
        return prev;
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i != 0) temp.add(nums[i]);
            if(i != n-1) temp2.add(nums[i]);
        }

        return Math.max(solve(temp),solve(temp2));
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(rob(nums));
    }
}
