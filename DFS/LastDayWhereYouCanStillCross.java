
// LAST DAY WHERE YOU CAN STILL CROSS
// LEETCODE-1970
// BEST FOR ;_ DFS + BINARY SEARCH PROBLEM(YOU CAN ALSO USE BFS)
class solution {
    int ROW;
    int COL;
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    // DFS to check if we can reach bottom row
    private boolean dfs(int[][] grid,int i, int j){
        if(i<0 || i>=ROW || j<0 || j>= COL || grid[i][j]==-1){
            return false;

        }
        if(i==ROW-1){
            return true;
        }
        // Mark visited /flooded
        grid[i][j]=1;

        for(int[] dir:directions){
            int newI=i+dir[0];
            int newJ=j+dir[1];

            if(dfs(grid, newI,newJ)){
                return true;
            }
        }
        return false;
    }
    // check if crossing is possible on given day
    private boolean cancross(int[][] cells,int day){
        int [][]grid=new int[ROW][COL];
        // mark flooded cells up to given day
        for(int i=0;i<=day;i++){
            int r=cells[i][0]-1;
            int c=cells[i][1]-1;
            grid[r][c]=1;
        }
        // try starting from top row
        for(int j=0;j<COL;j++){
            if(grid[0][j]==0 && dfs(grid,0,j)){
                return true;
            }
        }
        return false;
    }
    public int LastestDayToCross(int row,int col,int[][] cells){
        ROW=row;
        COL=col;
        int l=0;
        int r=cells.length-1;
        int lastDay=0;

        // binary search on days
        while(l<=r){
            int mid=l+(l-r)/2;
            if(cancross(cells, mid)){
                lastDay=mid+1;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return lastDay;
    }
}
