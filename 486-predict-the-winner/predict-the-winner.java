class Solution {

    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new Integer[n][n];

        return solve(nums, 0, n - 1) >= 0;
    }

    private int solve(int[] nums, int i, int j) {

        // Base Case
        if (i == j)
            return nums[i];

        // Memoization
        if (dp[i][j] != null)
            return dp[i][j];

        // Pick Left
        int left = nums[i] - solve(nums, i + 1, j);

        // Pick Right
        int right = nums[j] - solve(nums, i, j - 1);

        // Store & Return
        return dp[i][j] = Math.max(left, right);
    }
}