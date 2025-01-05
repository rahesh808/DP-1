class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        return recurse(coins, amount, 0, 0);
    }

    private int recurse(int[] coins, int amount, int index, int coinsUsed) {

        if (amount < 0 || index == coins.length) {
            return -1;
        }
        if (amount == 0) {
            return coinsUsed;
        }

        int case_0 = recurse(coins, amount, index + 1, coinsUsed);
        int case_1 = recurse(coins, amount - coins[index], index, coinsUsed + 1);

        if (case_0 == -1) {
            return case_1;
        }
        if (case_1 == -1) {
            return case_0;
        }

        return Math.min(case_0, case_1);

    }
}