class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int mx;
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            mx = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    mx = Math.max(dp[j], mx);
            }
            dp[i] = mx + 1;
        }
        mx = 0;
        for (int i = 0; i < nums.length; i++)
            mx = Math.max(dp[i], mx);
        return mx;
    }
}
