class Solution {
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];

        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int tempMax = maxProduct;

            maxProduct = Math.max(
                num,
                Math.max(maxProduct * num, minProduct * num)
            );

            minProduct = Math.min(
                num,
                Math.min(tempMax * num, minProduct * num)
            );

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}