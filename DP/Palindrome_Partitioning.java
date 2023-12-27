package DP;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>list=new ArrayList<String>();
        solve(0,s,list,ans);
          return ans;
    }
    static void solve(int index,String s,  List<String>list, List<List<String>>ans)
    {
        if(index==s.length())
        {
            ans.add(new ArrayList<>(list));
             return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(check_palindrome(s,index,i))
            {
                String current_string=s.substring(index,i+1);
                list.add(current_string);
                 solve(i+1,s,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    static boolean check_palindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
