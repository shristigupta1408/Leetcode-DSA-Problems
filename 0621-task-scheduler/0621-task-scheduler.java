class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Max Heap Approach -
        int[] taskFreq = new int[26];

        for (char ch : tasks) {
            taskFreq[ch - 'A'] += 1;
        }

        PriorityQueue<Integer> counts = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> remainingTasks = new LinkedList<>();

        for (int i = 0; i < taskFreq.length; i++) {
            if (taskFreq[i] > 0) {
                counts.add(taskFreq[i]);
            }
        }

        int time = 0;

        while (!counts.isEmpty() || !remainingTasks.isEmpty()) {
            time++;

            if (counts.isEmpty()) {
                time = remainingTasks.peek()[1];
            } else {
                int count = counts.poll() - 1;
                if (count > 0) {
                    remainingTasks.add(new int[]{count, time + n});
                }
            }

            if (!remainingTasks.isEmpty() && time == remainingTasks.peek()[1]) {
                counts.add(remainingTasks.poll()[0]);
            }
        } 

        return time;
    }
}