class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        if (len == 1)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2 ; i < len ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return Math.max(dp[len-1], dp[len - 2]);
    }
}
