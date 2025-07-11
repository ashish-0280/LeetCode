class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCounts = new int[n];
        long[] endTimes = new long[n];
        
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            
            // Find rooms that are free before the meeting starts
            int freeRoom = -1;
            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= start) {
                    freeRoom = i;
                    break;
                }
            }
            
            if (freeRoom != -1) {
                // Room available: schedule the meeting in freeRoom
                endTimes[freeRoom] = start + duration;
                meetingCounts[freeRoom]++;
            } else {
                // No rooms free: find earliest available room
                int earliestRoom = 0;
                long earliestEndTime = endTimes[0];
                
                for (int i = 1; i < n; i++) {
                    if (endTimes[i] < earliestEndTime) {
                        earliestEndTime = endTimes[i];
                        earliestRoom = i;
                    }
                }
                
                // Delay meeting until earliest room is free
                endTimes[earliestRoom] = earliestEndTime + duration;
                meetingCounts[earliestRoom]++;
            }
        }
        
        // Find the room with the most meetings
        int maxMeetings = 0;
        int roomWithMaxMeetings = 0;
        
        for (int i = 0; i < n; i++) {
            if (meetingCounts[i] > maxMeetings) {
                maxMeetings = meetingCounts[i];
                roomWithMaxMeetings = i;
            }
        }
        
        return roomWithMaxMeetings;
    }
}