package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
   int dx[] = { -1, 0, 1, 0 };
   int dy[] = { 0, 1, 0, -1 };
    public int numIslands(char[][] grid) {
        int islands=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    islands++;
                    bfs(grid,vis,i,j,n,m);
                }
            }
        }
        return islands;
    }
    void bfs(char grid[][],boolean vis[][],int cr,int cc,int n,int m)
    {
        Queue<int[]>q =new LinkedList<>();
        vis[cr][cc]=true;
        q.add(new int[]{cr,cc});
        while(!q.isEmpty())
        {
            int c[]=q.peek();
            q.remove();
            int cx=c[0];
            int cy=c[1];
            for(int i=0;i<4;i++)
            {
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(valid(nx,ny,n,m,vis,grid))
                {
                    q.add(new int[]{nx,ny});
                    vis[nx][ny]=true;
                }
            }
        }
    }
    boolean valid(int cr,int cc,int n,int m,boolean vis[][],char grid[][])
    {
        return cr>=0 && cr<n && cc>=0 && cc<m && !vis[cr][cc] && grid[cr][cc]=='1';
    }
}
