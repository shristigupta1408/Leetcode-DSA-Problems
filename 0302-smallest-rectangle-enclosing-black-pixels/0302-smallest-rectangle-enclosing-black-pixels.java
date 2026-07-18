class Solution {
    private final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        int minRow = x;
        int maxRow = x;
        int minCol = y;
        int maxCol = y;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        // Mark the starting pixel as visited immediately
        image[x][y] = '2';

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int row = pixel[0];
            int col = pixel[1];

            minRow = Math.min(minRow, row);
            maxRow = Math.max(maxRow, row);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (
                    newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n ||
                    image[newRow][newCol] != '1'
                ) {
                    continue;
                }

                image[newRow][newCol] = '2';
                queue.offer(new int[]{newRow, newCol});
            }
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}