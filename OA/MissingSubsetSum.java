package OA;
import java.util.*;
// You need to find the smallest positive integer (starting from 1) that cannot be formed
//  as a subset sum using any combination of elements from the array.
public class MissingSubsetSum {

    public static int findSmallestMissingSum(int[] arr) {
        Arrays.sort(arr);
        int smallestMissing = 1;

        for (int num : arr) {
            if (num <= smallestMissing) {
                smallestMissing += num;
            } else {
                break;
            }
        }

        return smallestMissing;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 10};

        int result = findSmallestMissingSum(arr);
        System.out.println("Output: " + result);
    }
}
