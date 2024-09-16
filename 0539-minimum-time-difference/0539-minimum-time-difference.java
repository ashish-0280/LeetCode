class Solution {
    public int findMinDifference(List<String> timePoints) {
        int arr[] = new int[timePoints.size()];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<timePoints.size(); i++){
            String parts[] = timePoints.get(i).split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int minutes1 = hours*60;
            arr[i] = minutes + minutes1;
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            int diff = arr[i+1]-arr[i];
            min = Math.min(min, diff);
        }
        int circularDiff = 1440 - (arr[arr.length-1]-arr[0]);
        min = Math.min(min, circularDiff);
        return min;
    }
}