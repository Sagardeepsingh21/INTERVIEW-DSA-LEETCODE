class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsecutiveHBars=1;
        int maxConsecutiveVBars=1;

        int currConsecutiveHBars=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                currConsecutiveHBars++;
            }else{
                currConsecutiveHBars=1;
            }
            maxConsecutiveHBars=Math.max(currConsecutiveHBars,maxConsecutiveHBars);
        }

         int currConsecutiveVBars=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                currConsecutiveVBars++;
            }else{
                currConsecutiveVBars=1;
            }
            maxConsecutiveVBars=Math.max(currConsecutiveVBars,maxConsecutiveVBars);
        }

        int side=Math.min(maxConsecutiveHBars,maxConsecutiveVBars)+1;
        return side*side;


    }
}
