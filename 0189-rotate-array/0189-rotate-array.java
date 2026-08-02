class Solution {
    public void rotate(int[] nums, int k) {
        // Double Ended Queue?
        // Get the last k number of elements, store them in a stack, then pop them and add them to an array + the rest of the elements
        // In place?? Needs to be in place. Returns void.
        // ArrayList
        int n = nums.length;
        k %= nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}