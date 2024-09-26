class MyCalendar {
    private final TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    /**
     * Tries to book an interval from start to end.
     * @param start the starting time of the interval
     * @param end the ending time of the interval
     * @return true if the booking does not conflict with existing bookings, false otherwise
     */
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }
        Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(start);
        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */