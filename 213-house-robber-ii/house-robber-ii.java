class Solution {
    int calc(int index, int [] nums, int []dp, int len) {
        if (index >= len)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int ans;

        ans = calc(index + 2, nums, dp, len) + nums[index];
        ans = Math.max(ans, calc(index+1, nums, dp, len));

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

        int ans = calc(0, nums, dp, len - 1);
         for (int i = 0 ; i < len ; i++)
            dp[i] = -1;

        ans = Math.max(ans,  calc(1, nums, dp, len));
        return ans;
    }
}
