class solution{
    public  long maxMatrixSum(int[][]matrix){
        int m=matrix.length;
        int n=matrix[0].length;

        long sum=0;
        int smallestabsolutevalue=Integer.MAX_VALUE;
        int countnegative=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum += Math.abs(matrix[i][j]);

                if(matrix[i][j]<0){
                    countnegative++;
                }

                smallestabsolutevalue=Math.min(smallestabsolutevalue,Math.abs(matrix[i][j]));
            }
        }
        if(countnegative % 2==0){
            return sum;
        }
        return sum-2L * smallestabsolutevalue;

    }
}
