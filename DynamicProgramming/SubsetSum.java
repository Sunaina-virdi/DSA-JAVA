package DynamicProgramming;

public class SubsetSum {
    // Recursion 
        // TC - O(2^N)
        // SC - O(N)
    // MEMO
        // TC - O(N * K)
        // SC - O(N * K) + O(N)
    // TABULATION
        // TC - O(N * K)
        // SC - O(N * K)
    // OPTIMIZE
        // TC - O(K)
        // SC - O(K)
    public static Boolean memo(int i,int n,int k,int arr[],Boolean dp[][]){
        if(k == 0) return true;
        if(i == n || k < 0) return false;
        if(dp[i][k] != null) return dp[i][k];
        
        return dp[i][k] = memo(i+1,n,k-arr[i],arr,dp) || memo(i+1,n,k,arr,dp);
        
    }
    public static Boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        Boolean dp[][] = new Boolean[n+1][k+1];
        return memo(0,n,k,arr,dp);
    }

    public static Boolean tabulation(int n,int k,int arr[]){
        boolean dp[][] = new boolean[n+1][k+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int target = 1; target <= k; target++){
                boolean take = false;
                if(arr[i-1] <= target){
                    take = dp[i-1][target - arr[i-1]];
                }
                boolean skip  = dp[i-1][target];

                dp[i][target] = take || skip;
            }
        }
        return dp[n][k];
    }
    public static boolean optimize(int n,int k,int arr[]){
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];
        prev[0] = curr[0] = true;
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            curr[0] = true;
            for(int target = 1; target <= k; target++){
                boolean skip  = prev[target];

                boolean take = false;
                if(arr[i] <= target)
                    take = prev[target - arr[i]];

                curr[target] = take || skip;
            }
            prev = curr.clone();
        }
        return prev[k];

    }
    public static void main(String[] args) {
        int n = 5,k = 4;
        int[]arr = {2,5,1,6,7};
        System.out.println(subsetSumToK(n, k, arr));
        System.out.println(tabulation(n, k, arr));
        System.out.println(optimize(n, k, arr));

    }
}
