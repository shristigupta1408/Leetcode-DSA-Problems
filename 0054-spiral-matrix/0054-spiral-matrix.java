class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = cols - 1;
        int down = rows - 1;

        while(result.size() != (rows * cols)) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[up][j]);
            }

            for (int i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }

            if (up != down) {
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[down][j]);
                }
            }

            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}