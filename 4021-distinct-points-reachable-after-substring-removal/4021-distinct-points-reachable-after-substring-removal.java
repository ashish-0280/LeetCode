class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        int x_axis[] = new int[n+1];
        int y_axis[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            x_axis[i+1] = x_axis[i];
            y_axis[i+1] = y_axis[i];

            if (s.charAt(i) == 'U') {
                y_axis[i+1]++;
            } else if (s.charAt(i) == 'L') {
                x_axis[i+1]--;
            } else if (s.charAt(i) == 'R') {
                x_axis[i+1]++;
            } else if (s.charAt(i) == 'D') {
                y_axis[i+1]--;
            }
        }
        Set<String> set = new HashSet<>();
        for(int i=0; i<=n-k; i++){
            int newX = x_axis[i] + (x_axis[n] - x_axis[i+k]);
            int newY = y_axis[i] + (y_axis[n] - y_axis[i+k]);
            String str = newX + "," + newY;
            set.add(str);
        }
        return set.size();
    }
}