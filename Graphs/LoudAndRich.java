package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        int par[]=new int[n];
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
        }
        int rL=richer.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<rL;i++)
        {
            int u=richer[i][0];
            int v=richer[i][1];
            indegree[richer[i][1]]++;
            if(!adj.containsKey(u))
             adj.put(u,new ArrayList<>());
             adj.get(u).add(v);
        }
        Queue<Integer> q =new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
             q.add(i);
        }
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
           
            if(adj.containsKey(node))
            {
                for(Integer nei:adj.get(node))
                {
                   if(quiet[par[node]]<quiet[par[nei]])
                   {
                   par[nei]=par[node];
                   }
                   indegree[nei]--;
                   if(indegree[nei]==0)
                   {
                       q.add(nei);
                   }
                }
            }
        }
       return par;
    }
}
