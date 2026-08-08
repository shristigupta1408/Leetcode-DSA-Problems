class Solution {
    public void rotate(int[][] matrix) {
        // I see a pattern that we take the first element from each bucket and that gets added to the new first bucket and so on
        // We could first reverse the 2d array (rows)
        // Then we need to swap the diagonal elements

        // Edge cases - 1 * 1 matrix -> do nothing

        int lo = 0;
        int hi = matrix.length - 1;
        int n = matrix.length;

        while (lo < hi) {
            int[] temp = matrix[lo];
            matrix[lo] = matrix[hi];
            matrix[hi] = temp;
            lo++;
            hi--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
}