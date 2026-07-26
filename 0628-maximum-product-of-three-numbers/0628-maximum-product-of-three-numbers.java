class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        return Math.max((nums[n-1] * nums[n-2] * nums[n-3]), (nums[0] * nums[1] * nums[n-1]));
        // int result = Integer.MIN_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         for (int k = j+1; k < nums.length; k++) {
        //             int product = nums[i] * nums[j] * nums[k];
        //             result = Math.max(result, product);
        //         }
        //     }
        // }

        // return result;
        
    }
}