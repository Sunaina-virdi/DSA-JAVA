package DynamicProgramming;

public class CountSubsetSumk {
    // recursion 
    // TC - (2^n)
    // SC - O(N)
     public static int solve(int num[],int idx,int tar){
        if(tar == 0) return 1;
        if(idx < 0 || tar < 0) return 0;
        
        int exclude = solve(num,idx-1,tar);
        int include = 0;
        if(num[idx] <= tar){
            include = solve(num,idx-1,tar-num[idx]);
        }
        return include + exclude;
    }
    public static int findWays(int num[], int tar) {
        return solve(num,num.length-1,tar);
    }
    public static void main(String[] args) {
        int num[] = {1,1,4,5};
        int tar = 5;
        System.out.println(findWays(num, tar));
    }
}
