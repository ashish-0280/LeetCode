class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>();
        for (String word : dictionary) {
            wordSet.add(word);
        }

        int n = s.length(); 
        int[] minExtraChars = new int[n + 1];
        minExtraChars[0] = 0; 
        for (int i = 1; i <= n; ++i) {
            minExtraChars[i] = minExtraChars[i - 1] + 1;
            for (int j = 0; j < i; ++j) {
                if (wordSet.contains(s.substring(j, i))) {
                    minExtraChars[i] = Math.min(minExtraChars[i], minExtraChars[j]);
                }
            }
        }
        return minExtraChars[n];
    }
}