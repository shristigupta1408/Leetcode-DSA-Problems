class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
            
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }

        System.out.printf("Numbers are %d %d %d %d %d%n", min1, min2, max1, max2, max3);

        return Math.max((min1 * min2 * max1), (max1 * max2 * max3));


        // int n = nums.length;
        // Arrays.sort(nums);

        // return Math.max((nums[n-1] * nums[n-2] * nums[n-3]), (nums[0] * nums[1] * nums[n-1]));

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