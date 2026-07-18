class Solution {
    // private final int[][] directions = {
    //     {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    // };

    // public int minArea(char[][] image, int x, int y) {
    //     int m = image.length;
    //     int n = image[0].length;

    //     int minRow = x;
    //     int maxRow = x;
    //     int minCol = y;
    //     int maxCol = y;

    //     Queue<int[]> queue = new ArrayDeque<>();
    //     queue.offer(new int[]{x, y});

    //     // Mark the starting pixel as visited immediately
    //     image[x][y] = '2';

    //     while (!queue.isEmpty()) {
    //         int[] pixel = queue.poll();
    //         int row = pixel[0];
    //         int col = pixel[1];

    //         minRow = Math.min(minRow, row);
    //         maxRow = Math.max(maxRow, row);
    //         minCol = Math.min(minCol, col);
    //         maxCol = Math.max(maxCol, col);

    //         for (int[] direction : directions) {
    //             int newRow = row + direction[0];
    //             int newCol = col + direction[1];

    //             if (
    //                 newRow < 0 || newRow >= m ||
    //                 newCol < 0 || newCol >= n ||
    //                 image[newRow][newCol] != '1'
    //             ) {
    //                 continue;
    //             }

    //             image[newRow][newCol] = '2';
    //             queue.offer(new int[]{newRow, newCol});
    //         }
    //     }

    //     int height = maxRow - minRow + 1;
    //     int width = maxCol - minCol + 1;

    //     return height * width;
    // }

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;

        int left = searchColumns(image, 0, y, true);
        int right = searchColumns(image, y + 1, n, false);

        int top = searchRows(image, 0, x, left, right, true);
        int bottom = searchRows(image, x + 1, m, left, right, false);

        return (right - left) * (bottom - top);
    }

    private int searchColumns(
        char[][] image,
        int start,
        int end,
        boolean findFirstBlack
    ) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean hasBlack = false;

            for (int row = 0; row < image.length; row++) {
                if (image[row][mid] == '1') {
                    hasBlack = true;
                    break;
                }
            }

            if (hasBlack == findFirstBlack) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int searchRows(
        char[][] image,
        int start,
        int end,
        int left,
        int right,
        boolean findFirstBlack
    ) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean hasBlack = false;

            for (int col = left; col < right; col++) {
                if (image[mid][col] == '1') {
                    hasBlack = true;
                    break;
                }
            }

            if (hasBlack == findFirstBlack) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
}
}