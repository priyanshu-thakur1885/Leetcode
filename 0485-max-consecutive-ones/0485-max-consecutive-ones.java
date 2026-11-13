class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0 ; 
        int maxCount =0;

        for(int num : nums){
            if(num==1){
                count++;

                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}