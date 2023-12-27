package Strings;

import java.util.Stack;

public class Min_Remove {
    public String minRemoveToMakeValid(String s) {
        Stack<Character>stack=new Stack<>();
        int validCount=0;
        for(Character c:s.toCharArray()){
            if(c=='('){
                validCount++;
                stack.add(c);
            }
            else if(c==')'){
                validCount--;
                if(validCount<0){
                    validCount=0;
                }
                else{
                    stack.add(c);
                }
            }
            else{
                stack.add(c);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.empty()){
          char c=stack.pop();
           if(c=='('){
               if(validCount>0){
                   validCount--;
               }
               else{
                   ans.append(c);
               }
           }
           else{
               ans.append(c);
           }
        }
        return ans.reverse().toString(); 
    }
}
