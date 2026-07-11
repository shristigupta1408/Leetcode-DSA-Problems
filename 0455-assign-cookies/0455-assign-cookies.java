class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = 0;
        int sPointer = 0;

        while (sPointer < s.length && gPointer < g.length) {
            if (g[gPointer] <= s[sPointer]) {
                gPointer++;
            }

            sPointer++;
        }

        return gPointer;
    }
}