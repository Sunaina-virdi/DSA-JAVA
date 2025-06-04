package OA;
// You are given an array of integers representing the beauty values of flower beds arranged in a row. 
// Your goal is to determine the maximum total beauty you can achieve by selecting exactly two flower beds using the following rules:

// You must select the first and last flower beds initially.
// Out of these two, take the larger value.

// Then, check the remaining flower beds (excluding the first and last).
// From these, select the largest value that is greater than the smaller of the first/last (if such a value exists).
// Add the selected values (the larger of the first/last, and the one from the middle if found).
// Return the sum as the maximum beauty you can make.
// If there are only two flower beds (i.e., length is 2), just return their sum.

public class GardenBeautiful {
    public static int solve(int[]arr){
        int n = arr.length - 1;
        int first = arr[0];
        int second = arr[n];
        if(arr.length == 2){
            return first+second;
        }
        int large = first > second ? first : second;
        // System.out.println(large);
        int small = first > second ? second : first;
        // System.out.println(small);
        for(int i=1;i<n;i++){
            if(arr[i] > small){
                small = arr[i];
            }
        }
        return large + small;
    }
    public static void main(String[] args) {
        int[] arr = {2,7,3,1};
        System.out.println(solve(arr));
    }
}
