//416: Partition Equal subset sum
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
// Time complexity: O(n * target), where n is the number of elements in nums and target is the sum of the subset we are trying to find.
// Space complexity: O(target), where target is the sum of the subset we are trying to find.