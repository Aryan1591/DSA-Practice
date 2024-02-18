package BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator implements Iterator<Integer>  {
      Queue<Integer>q;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        q=new LinkedList<>();
         dfs(nestedList);
    }

    @Override
    public Integer next() {
        return q.remove();
    }

    @Override
    public boolean hasNext() {
        return q.size()>0 ? true: false;
    }

    void dfs(List<NestedInteger> nestedList)
    {
         for(NestedInteger x:nestedList)
         {
             if(x.isInteger())
             {
                 q.add(x.getInteger());
             }
             else 
             {
                 dfs(x.getList());
             }
         }
    }
}
 interface NestedInteger {
    
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
 // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
    