class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Start time needs to be after end time
        // End time needs to be checked against previous start time
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];

        int numberOfRooms = 0;

        int startPointer = 0;
        int endPointer = 0;

        for (int i = 0; i < length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        while (startPointer < length) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                endPointer += 1;
                numberOfRooms -= 1;
            }

            startPointer += 1;
            numberOfRooms += 1;
        }

        return numberOfRooms;
    }
}