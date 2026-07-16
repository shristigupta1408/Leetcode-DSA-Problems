class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int i = 0;
        int n = s.length();
        int ans = 0;

        for (int j = 0; j < n; j++) {
            if (lastIndex.containsKey(s.charAt(j))) {
                i = Math.max(lastIndex.get(s.charAt(j)), i);
            }

            lastIndex.put(s.charAt(j), j+1);
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}