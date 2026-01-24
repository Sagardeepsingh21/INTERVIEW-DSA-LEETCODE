class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxResult=0;

        int i=0,j=nums.length-1;

        while(i<j){
            int sum= nums[i]+nums[j];

            maxResult=Math.max(maxResult,sum);
            i++;
            j--;
        }
        return maxResult;
    }
}