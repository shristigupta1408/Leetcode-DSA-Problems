class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        int minProduct = 1;
        int result = nums[0];

        for (int num : nums) {
            int temp = maxProduct * num;
            maxProduct = Math.max(Math.max(temp, minProduct * num), num);
            minProduct = Math.min(Math.min(temp, minProduct * num), num);
            result = Math.max(maxProduct, result);
        }

        return result;
    }
}