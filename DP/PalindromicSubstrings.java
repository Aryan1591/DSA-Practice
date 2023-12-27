package DP;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count=0;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j]=true;
                }
                else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j))dp[i][j]=true;
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])dp[i][j]=true;
                }
                if(dp[i][j])count++;
            }
        } 
        return count;
    }
    //2nd method
    public int countSubstrings2(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            count+=extendedPalindrome(i,i,s,n);
            count+=extendedPalindrome(i,i+1,s,n);
        }
        return count;
    }
    int extendedPalindrome(int start,int end,String s,int length){
        int count=0;
         while(start>=0 && end<length && s.charAt(start)==s.charAt(end)){
           count++;
           start--;
           end++;}
          return count; 
    }
}
