package DynamicProgramming.DP_2D;
// leetcode 5
public class LongestPalindromicSubstring {
    // TC - O(N3)
// SC - O(1)

    // public boolean palindrome(String s,int start,int end){
    //     while(start <= end){
    //         if(s.charAt(start) != s.charAt(end)) return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }

// TC - O(N2)
// SC - O(N2)

    public boolean memo(String s,int start,int end,boolean [][]dp){
        if(start >= end) return true;
        if(dp[start][end]) return true;

        if(s.charAt(start) == s.charAt(end) && memo(s,start+1,end-1,dp)){
            dp[start][end] = true;
            return true;
        }
        return false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;

        int index = 0;
        int maxlen = 0;

        boolean[][] dp = new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j < n ; j++){
                if(memo(s,i,j,dp)){
                    if(j - i + 1 > maxlen){
                        maxlen = j - i + 1;
                        index = i;
                    }
                }
            }
        }
        return s.substring(index,index+maxlen);
    }
}
