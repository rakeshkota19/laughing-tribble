class Solution {
    int calc(int index, int [] nums, int []dp) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int ans;

        ans = calc(index + 2, nums, dp) + nums[index];
        ans = Math.max(ans, calc(index+1, nums, dp));

        dp[index] = ans;
        return ans;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 0 ; i < len ; i++)
            dp[i] = -1;

        if (len == 1)
            return nums[0];

      return calc(0, nums, dp);
    }
}
