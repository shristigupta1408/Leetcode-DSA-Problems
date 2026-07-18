class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minArea(char[][] image, int x, int y) {
        // Need to track the range of x and y indices
        Set<Integer> xRange = new HashSet<>();
        Set<Integer> yRange = new HashSet<>();

        // xRange.add(x);
        // yRange.add(y);

        int m = image.length;
        int n = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            xRange.add(pixel[0]);
            yRange.add(pixel[1]);

            for (int[] direction : directions) {
                int newRow = pixel[0] + direction[0];
                int newCol = pixel[1] + direction[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || image[newRow][newCol] == '2') {
                    continue;
                }

                if (image[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                }

                image[newRow][newCol] = '2';
            }
        }

        int height = Collections.max(xRange) - Collections.min(xRange) + 1;
        int width = Collections.max(yRange) - Collections.min(yRange) + 1;

        return height * width;
    }
}