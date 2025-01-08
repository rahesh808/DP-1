/*
Time Complexity O(2^N)
Space Complexity O(1)
*/

class problem2_solution1
 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return recurse(nums, 0, 0);

    }

    private int recurse(int[] nums, int index, int amountRobbed) {
        if (index >= nums.length) {
            return amountRobbed;
        }
        // Not Robbing the house
        int case1 = recurse(nums, index + 1, amountRobbed);

        // Robbing the current house
        int case2 = recurse(nums, index + 2, amountRobbed + nums[index]);

        return Math.max(case1, case2);

    }
}