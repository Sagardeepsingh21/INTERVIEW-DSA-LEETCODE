// LeetCode-840
// IS MAGIC SQUARES IN GRID
// Best for 2_D Array logic building

// JAVA SOLUTION:-

import java.util.HashSet;
import java.util.Set;

class solution{
    private boolean isMagicGrid(int[][] grid,int r, int c){
        // uniqueness check for number 1-9
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num=grid[r+i][c+j];
                if(num<1 || num>9 || st.contains(num)){
                    return false;
                }else{
                    st.add(num);
                }
            }
        }
        // check the sum of row and columns
        int sum=grid[r][c] +grid[r][c+1]+grid[r][c+2];

        for(int i=0;i<3;i++){
            if(grid[r+i][c] + grid[r+i][c+1]+grid[r+i][c+2]!=sum){
                return false;
            }
             if(grid[r][c+i] + grid[r+1][c+i]+grid[r+2][c+i]!=sum){
                return false;
            }
        }

        // check the sum of daigonal and non-diagonal elements
        if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] != sum){
            return false;
        }
        if(grid[r][c+2]+grid[r+1][c-1]+grid[r+2][c-2] != sum){
            return false;
        }

        return true;
    }
    public int numMagicSquaresInside(int[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;

        for(int i=0;i<=rows-3;i++){
            for(int j=0;j<=cols-3;j++){
                if(isMagicGrid(grid,i,j)){
                    count++;
                }
            }
        }

        return count;
    }
}