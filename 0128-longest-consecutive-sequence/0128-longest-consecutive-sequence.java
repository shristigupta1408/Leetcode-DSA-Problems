class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numsSet) {
            if (!numsSet.contains(num-1)) {
                int currentStreak = 1;
                int currentNum = num;

                while (numsSet.contains(currentNum + 1)) {
                    currentStreak += 1;
                    currentNum = currentNum + 1;
                }

            longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}