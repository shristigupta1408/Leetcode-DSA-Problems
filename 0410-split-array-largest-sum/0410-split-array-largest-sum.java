class Solution {
    public int splitArray(int[] nums, int k) {
        // Subarray - CONTIGUOUS!!
        // Need to keep a balanced approach
        // Edge cases - nums length < k - can we have empty subarrays then?
        // ^ Constraint - k <= nums.length
        // Can we have negative numbers - No
        // Each subarray would have to have at least n // 2 elements - Not really
        // Sliding Window
        // Need to get all combinations - something like DP/Backtracking?
        // 2D array sum 
        // Prefix sum -> compare sum at index i with number at last index - sum at index i -> store max somewhere, in the end return minimum from the maxes
        // This won't work for k > 2
        // Binary Search?

        int sum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int element : nums) {
            sum += element;
            maxElement = Math.max(maxElement, element);
        }

        int left = maxElement;
        int right = sum;
        int minLargestSplitSum = 0;

        while (left <= right) {
            int maxAllowed = left + (right - left) / 2;

            if (minSubarraysRequired(nums, maxAllowed) <= k) {
                right = maxAllowed - 1;
                minLargestSplitSum = maxAllowed;
            } else {
                left = maxAllowed + 1;
            }
        }

        return minLargestSplitSum;
        
    }

    private int minSubarraysRequired(int[] nums, int maxAllowed) {
        int currSum = 0;
        int splitsRequired = 0;

        for (int element : nums) {
            if (currSum + element <= maxAllowed) {
                currSum += element;
            } else {
                currSum = element;
                splitsRequired++;
            }
        }

        return splitsRequired + 1;
    }
}