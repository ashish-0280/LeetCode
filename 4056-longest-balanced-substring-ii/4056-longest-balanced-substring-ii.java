class Solution {
    public int longestBalanced(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int champ = 1, streak = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) streak++;
            else {
                champ = Math.max(champ, streak);
                streak = 1;
            }
        }
        champ = Math.max(champ, streak);

        int u = 0, v = 0, w = 0;
        Map<String, Integer> tracker = new HashMap<>();
        tracker.put("0,0", -1);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') u++;
            else if (ch == 'b') v++;
            else if (ch == 'c') w++;

            String key = (u - v) + "," + (u - w);
            if (tracker.containsKey(key)) champ = Math.max(champ, i - tracker.get(key));
            else tracker.put(key, i);
        }

        champ = Math.max(champ, maxPairRun(s, 'a', 'b', 'c'));
        champ = Math.max(champ, maxPairRun(s, 'a', 'c', 'b'));
        champ = Math.max(champ, maxPairRun(s, 'b', 'c', 'a'));

        return champ;
    }

    private int maxPairRun(String s, char x, char y, char sep) {
        int n = s.length(), best = 0;
        for (int i = 0; i < n; ) {
            while (i < n && s.charAt(i) == sep) i++;
            if (i >= n) break;
            int start = i;
            while (i < n && s.charAt(i) != sep) i++;
            best = Math.max(best, pairBalance(s, start, i - 1, x, y));
        }
        return best;
    }

    private int pairBalance(String s, int start, int end, char x, char y) {
        Map<Integer, Integer> tracker = new HashMap<>();
        int diff = 0, best = 0;
        tracker.put(0, start - 1);

        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (ch == x) diff++;
            else if (ch == y) diff--;
            if (tracker.containsKey(diff)) best = Math.max(best, i - tracker.get(diff));
            else tracker.put(diff, i);
        }
        return best;
    }
}