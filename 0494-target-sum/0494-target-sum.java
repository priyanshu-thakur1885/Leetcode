class Solution {
    public int solve(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target)
                return 1;
            return 0;
        }

        int plusSign = solve(nums, index + 1, sum + nums[index], target);
        int negativeSign = solve(nums, index + 1, sum - nums[index], target);

        return plusSign + negativeSign;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
}