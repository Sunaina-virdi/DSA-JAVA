package Recursion;

public class PalindromeString {
    static boolean solve(String s,int start,int end){
        if(start >= end)
            return true;
        
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        return solve(s,start+1,end-1);
    }
    static boolean isPalindrome(String s) {
        // code here
        int n = s.length();
        return solve(s,0,n-1);
    }
    public static void main(String[] args) {
        String s = "abbc";
        if(isPalindrome(s)){
            System.out.println("true");
        }
        else System.out.println("false");
    }
}
