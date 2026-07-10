class Solution {
    public int rob(int[] nums) {
        int prev0 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int temp = Math.max(num + prev0, prev1);
            prev0 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}