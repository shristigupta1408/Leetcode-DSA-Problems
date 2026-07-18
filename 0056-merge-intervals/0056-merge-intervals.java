class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= prevEnd) {
                prevEnd = Math.max(end, prevEnd);
            } else {
                merged.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            }
        }

        merged.add(new int[]{prevStart, prevEnd});

        return merged.toArray(new int[merged.size()][]);
    }
}