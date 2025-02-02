class Solution {
    public int maxDistance(String s, int k) {
        int arr[] = new int[2];
        int p = k;
        int max = Integer.MIN_VALUE;

        //North-East
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'E'){
                arr[0]++;
            } else if(s.charAt(i) == 'W' && p != 0){
                arr[0]++; p--;
            } else if(s.charAt(i) == 'W' && p == 0){
                arr[0]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
            if(s.charAt(i) == 'N'){
                arr[1]++;
            } else if(s.charAt(i) == 'S' && p != 0){
                arr[1]++; p--;
            } else if(s.charAt(i) == 'S' && p == 0){
                arr[1]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
        }
        //North-West
        p = k;
        Arrays.fill(arr, 0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'W'){
                arr[0]++;
            } else if(s.charAt(i) == 'E' && p != 0){
                arr[0]++; p--;
            } else if(s.charAt(i) == 'E' && p == 0){
                arr[0]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
            if(s.charAt(i) == 'N'){
                arr[1]++;
            } else if(s.charAt(i) == 'S' && p != 0){
                arr[1]++; p--;
            } else if(s.charAt(i) == 'S' && p == 0){
                arr[1]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
        }
        //South-East
        p = k;
        Arrays.fill(arr, 0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'E'){
                arr[0]++;
            } else if(s.charAt(i) == 'W' && p != 0){
                arr[0]++; p--;
            } else if(s.charAt(i) == 'W' && p == 0){
                arr[0]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
            if(s.charAt(i) == 'S'){
                arr[1]++;
            } else if(s.charAt(i) == 'N' && p != 0){
                arr[1]++; p--;
            } else if(s.charAt(i) == 'N' && p == 0){
                arr[1]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
        }
        //South-West
        p = k;
        Arrays.fill(arr, 0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'W'){
                arr[0]++;
            } else if(s.charAt(i) == 'E' && p != 0){
                arr[0]++; p--;
            } else if(s.charAt(i) == 'E' && p == 0){
                arr[0]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
            if(s.charAt(i) == 'S'){
                arr[1]++;
            } else if(s.charAt(i) == 'N' && p != 0){
                arr[1]++; p--;
            } else if(s.charAt(i) == 'N' && p == 0){
                arr[1]--;
            }
            max = Math.max(max, arr[0] + arr[1]);
        }
        return max;
    }
}