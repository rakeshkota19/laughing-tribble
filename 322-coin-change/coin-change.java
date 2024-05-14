class Solution {

    int calc(int index, int[] coins, int target, int [][] dp) {
        if (target < 0) 
            return 100001;   

        if (target == 0)
            return 0;

        if (index == coins.length)
            return 100001;

        int len = coins.length;
        if (dp[index][target] != -1)
            return dp[index][target];

        int o_target = target;
       // System.out.println(index + " " + target);
        int ans = 100001;
        int i = 0;
        ans = Math.min(ans, calc(index+1, coins, target, dp));

        while (target >= coins[index])  {
            i++;
            target -= coins[index];
            int val = calc(index + 1, coins, target, dp) + i;
            ans = Math.min(ans, val);
        }

        dp[index][o_target] = ans;
        return ans;
    }


    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int dp[][] = new int[len][amount + 1];

        for (int i = 0 ; i < len ; i++)
            for (int j = 0 ; j <= amount; j++)
                dp[i][j] = -1;

        int val =  calc(0, coins, amount, dp);
        return val == 100001 ? -1 : val;
        // return dp[amount];
    }
}