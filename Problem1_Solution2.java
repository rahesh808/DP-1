class Solution2 {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }
        int n = coins.length;
        int[][] dp_array = new int[n + 1][amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp_array[0][i] = amount + 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {

                if(j < coins[i-1]) {
                    dp_array[i][j] = dp_array[i-1][j];
                }
                else {
                  dp_array[i][j] = Math.min(dp_array[i - 1][j], dp_array[i][j- coins[i-1]] + 1);  
                }
                if(dp_array[n][amount] == amount+1) {
                    return -1;
                }
            }
        }
        return dp_array[n][amount];
    }
}