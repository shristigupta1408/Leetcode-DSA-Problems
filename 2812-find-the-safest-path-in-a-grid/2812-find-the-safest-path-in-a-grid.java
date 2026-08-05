class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // Find the path that is furthest from the thief
        // Need to know where the thieves are
        // Starting from (0,0) -> (n-1, n-1)
        // BFS starting from thieves -> mark distance to adjacent cells
        // Recursion - min dist[cell] = min(dist[adj cells]) + 1
        // Then traverse all paths from source to end cell - min number found -> safeness factor
        // max(safeness factors)
        // Edge cases - no thieves present? - Constraint at least 1 thief
        // 2 paths have the same safeness factor? just return factor

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = grid.size();
        int[][] maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[] {i, j});
                    maze[i][j] = 0;
                } else {
                    maze[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                int val = maze[cell[0]][cell[1]];

                if (row >= n || row < 0 || col >= n || col < 0 || maze[row][col] != -1) { continue; }

                maze[row][col] = val + 1;
                q.add(new int[] {row, col});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[] {0, 0, maze[0][0]});
        maze[0][0] = -1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[2];

            if (curr[0] == n-1 && curr[1] == n-1) {
                return curr[2];
            }

            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];      

                if (row >= n || row < 0 || col >= n || col < 0 || maze[row][col] == -1) { continue; }

                pq.add(new int[] {row, col, Math.min(val, maze[row][col])});
                maze[row][col] = -1;
            }
        }

        return -1;
    }
}