package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>>map=new HashMap<>();
         int size=equations.size();
          for(int i=0;i<size;i++)
          {
            List<String>temp=equations.get(i);
               String dividend=temp.get(0);
               String divisor=temp.get(1);
                double value=values[i];
                if(!map.containsKey(dividend))
                {
                    map.put(dividend,new HashMap<>());
                }
                if(!map.containsKey(divisor))
                {
                    map.put(divisor,new HashMap<>());
                }
                map.get(dividend).put(divisor,value);
                map.get(divisor).put(dividend,1/value);
          }
          int final_size=queries.size();
          double ans[]=new double[final_size];
           for(int i=0;i<final_size;i++)
           {
               String start=queries.get(i).get(0);
               String end=queries.get(i).get(1);
                if(!map.containsKey(start) || !map.containsKey(end))
                {
                    ans[i]=-1.0;
                }
                else {
                    HashSet<String>hs=new HashSet<>();
                    ans[i]=dfs(map,start,end,1.0,hs);
                }
           }
               return ans;
    }
     double dfs(HashMap<String,HashMap<String,Double>>map,String node,String target,double res,HashSet<String>visit)
     {
           if(node.equals(target))
             return res;
             visit.add(node);
   
           HashMap<String,Double>mp=map.get(node);
            for(String s:mp.keySet())
            {
                 if(visit.contains(s))
                   continue;
                 double current_ans=dfs(map,s,target,res*mp.get(s),visit);
                 if(current_ans!=-1.0)
                    return current_ans;
            }
            visit.remove(node);
            return -1.0;

     }
}
