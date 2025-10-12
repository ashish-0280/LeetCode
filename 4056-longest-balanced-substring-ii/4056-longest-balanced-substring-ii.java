class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int maxLen = 1, runLen = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) runLen++;
            else {
                maxLen = Math.max(maxLen, runLen);
                runLen = 1;
            }
        }
        maxLen = Math.max(maxLen, runLen);

        int cntA = 0, cntB = 0, cntC = 0;
        Map<String, Integer> diffMap = new HashMap<>();
        diffMap.put("0,0", -1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') cntA++;
            else if (ch == 'b') cntB++;
            else if (ch == 'c') cntC++;

            String key = (cntA - cntB) + "," + (cntA - cntC);
            if (diffMap.containsKey(key)) maxLen = Math.max(maxLen, i - diffMap.get(key));
            else diffMap.put(key, i);
        }

        maxLen = Math.max(maxLen, maxPair(s, 'a', 'b', 'c'));
        maxLen = Math.max(maxLen, maxPair(s, 'a', 'c', 'b'));
        maxLen = Math.max(maxLen, maxPair(s, 'b', 'c', 'a'));

        return maxLen;
    }

    private int maxPair(String s, char x, char y, char skip) {
        int n = s.length(), best = 0;
        for (int i = 0; i < n; ) {
            while (i < n && s.charAt(i) == skip) i++;
            if (i >= n) break;
            int start = i;
            while (i < n && s.charAt(i) != skip) i++;
            best = Math.max(best, pairBalance(s, start, i - 1, x, y));
        }
        return best;
    }

    private int pairBalance(String s, int start, int end, char x, char y) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        int diff = 0, best = 0;
        diffMap.put(0, start - 1);

        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (ch == x) diff++;
            else if (ch == y) diff--;
            if (diffMap.containsKey(diff)) best = Math.max(best, i - diffMap.get(diff));
            else diffMap.put(diff, i);
        }
        return best;
    }
}
