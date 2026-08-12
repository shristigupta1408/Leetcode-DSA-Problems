class Solution {
    // Edge cases - No common subsequence - return 0

    private int[][] memo;
    private String text1;
    private String text2;
    private int n;
    private int m;

    public int longestCommonSubsequence(String text1, String text2) {
        this.n = text1.length();
        this.m = text2.length();

        this.memo = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(this.memo[i], -1);
        }

        this.text1 = text1;
        this.text2 = text2;
        return memoSolve(0,0);
    }

    private int memoSolve(int p1, int p2) {
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        int ans = 0;

        if (p1 >= n || p2 >= m) { return 0; }

        if (text1.charAt(p1) == text2.charAt(p2)) {
            ans = 1 + memoSolve(p1 + 1, p2 + 1);
        } else {
            ans = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        memo[p1][p2] = ans;
        return ans;
    }
}