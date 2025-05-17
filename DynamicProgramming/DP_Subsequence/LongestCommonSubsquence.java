package DynamicProgramming.DP_Subsequence;
// leetcode 1143
import java.util.Arrays;

public class LongestCommonSubsquence{
    public static int lcs(String s,String t,int idx1,int idx2,int [][]dp){
        if(idx1 >= s.length() || idx2 >= t.length()) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int take = 0;
        int skip = 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            take = 1 + lcs(s,t,idx1+1,idx2+1,dp);
        }
        else{
            int stat_1 = lcs(s,t,idx1,idx2 + 1,dp);
            int stat_2 = lcs(s,t,idx1 + 1,idx2,dp);
            skip = Math.max(stat_1,stat_2);
        }
        return dp[idx1][idx2] = Math.max(take,skip);
    }
    public static int solve(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return lcs(text1,text2,0,0,dp);
    }
    public static void main(String[] args) {
        String text1 ="abcde";
        String text2 ="ace";
        System.out.println(solve(text1,text2));
    }
}