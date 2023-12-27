package DP;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parantheses {
     public List<String> generateParenthesis(int n) {
        ArrayList<String>ans=new ArrayList<String>();
         solve(ans,n,0,0,"");
          return ans;
    }
    static void solve(ArrayList<String>ans,int n,int open,int close,String s)
    {
        if(close==n)
        {
            ans.add(s);
             return;
        }
        if(open>close)
        {
            solve(ans,n,open,close+1,s+')');
        }
        if(open<n)
        {
            solve(ans,n,open+1,close,s+'(');
        }
    }
}
