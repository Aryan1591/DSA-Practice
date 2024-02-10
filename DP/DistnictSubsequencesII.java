package DP;

import java.util.HashMap;
import java.util.Map;

public class DistnictSubsequencesII {
    int mod=(int)1e9+7;
    public int distinctSubseqII(String s) {
        int len=s.length();
        long dp[]=new long[len+1];
        dp[0]=1;
        Map<Character,Integer> lastSeen = new HashMap<>();
        for(int i=1;i<=len;i++)
        {
            dp[i]=(2*dp[i-1])%mod;
            char cur = s.charAt(i-1);
        
        if(lastSeen.containsKey(cur)) 
            dp[i]=(dp[i]%mod - dp[lastSeen.get(cur)]%mod + mod)%mod;
        
        lastSeen.put(cur,i-1); 
        }
       return (int)(dp[len]-1+mod)%mod; 
    }
}
