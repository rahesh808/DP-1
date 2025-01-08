/*
TimeCOmplexity -> O(N)
Space Complexity -> O(N)
*/

class problem2_solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);
    }
}

/*
Time COmplexity -> O(N)
Space COmplexity -> O(1)
*/



class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int skip = 0;
        int rob = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int skipTemp = skip;
            skip = Math.max(skip, rob);
            rob = nums[i] + skipTemp;
        }
        return Math.max(skip, rob);
    }
}