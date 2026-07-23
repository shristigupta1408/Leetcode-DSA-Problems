class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int count = 0;
        int sum = 0;
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            int target = sum - k;

            if (prefixSum.containsKey(target)) {
                count += prefixSum.get(target);
            }

            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}