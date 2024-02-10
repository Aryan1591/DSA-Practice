package BinarySearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTheSafestPathInAGrid {
       int dx[] = { -1, 0, 1, 0 };
       int dy[] = { 0, 1, 0, -1 };
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int dis[][]=new int[n][n];
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1)
                {
                    q.add(new int[]{i,j,0});
                    dis[i][j]=0;
                }
                else{
                    dis[i][j]=(int)1e9;
                }
            }
        }
        while(!q.isEmpty())
        {
            int a[]=q.remove();
            for(int i=0;i<4;i++)
            {
                int nx=a[0]+dx[i];
                int ny=a[1]+dy[i];
               if(nx>=0 && nx<n && ny>=0 && ny<n && dis[nx][ny]>1+a[2])
               {
                   q.add(new int[]{nx,ny,1+a[2]});
                   dis[nx][ny]=1+a[2];
               } 
            }
        }
        int maxFactor = 0;
        int low=0;
        int high=n;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //consider mid as safeness factor
            int matrix[][]=construct(mid,dis);
            if(possible(matrix,n))
            {
                maxFactor=Math.max(maxFactor,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return maxFactor;

    }
    boolean possible(int[][] matrix,int n)
    {
        Queue<int[]>q =new LinkedList<>();
        if(matrix[0][0]==-1 || matrix[n-1][n-1]==-1)
          return false;
        q.add(new int[]{0,0});
        boolean vis[][]=new boolean[n][n];
        vis[0][0]=true;
        while(!q.isEmpty())
        {
          int a[]=q.remove();
          int cx=a[0];
          int cy=a[1];
          if(cx==n-1 && cy==n-1)
            return true;
          for(int i=0;i<4;i++)
          {
              int nx=cx+dx[i];
              int ny=cy+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && !vis[nx][ny] && matrix[nx][ny]!=-1)
            {
                vis[nx][ny]=true;
                q.add(new int[]{nx,ny});
            }  
          }
        }
        return false;  
    }
    int[][] construct(int mid,int dis[][])
    {
        int n=dis.length;
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dis[i][j]<mid)
                {
                    mat[i][j]=-1;
                }
            }
        }
        return mat;
    } 
}
