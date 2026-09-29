class Solution {
    private boolean[][][] visited;
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int maxbal=(m+n)/2;
        //Basic impossible conditions
        if((m+n-1)%2!=0||grid[0][0]==')'||grid[m-1][n-1]=='(')
        return false;
        visited=new boolean[m][n][maxbal+1];
        return dfs(grid,0,0,0,m,n,maxbal);
    }
    boolean dfs(char[][] grid,int r,int c,int bal,int m,int n,int maxbal){
        bal+=(grid[r][c]=='(')?1:-1;
        //Invalid balance
        if(bal<0 || bal>maxbal)
          return false;
        //checking that we are reached the end or not
        if(r==m-1&&c==n-1)
          return bal==0;
        //checking that we are already visited 
        if(visited[r][c][bal])
          return false;
        visited[r][c][bal]=true;
        // Moving down
        if(r+1<m && dfs(grid,r+1,c,bal,m,n,maxbal))
          return true;
        // Moving right
        if(c+1<n && dfs(grid,r,c+1,bal,m,n,maxbal))
          return true;
        return false;
    }
}
