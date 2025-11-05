class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        StringBuilder halfPart = new StringBuilder();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) oddCount++;
        }

        if (oddCount > 1) {
            return "";
        }

        int length = s.length();

        if (!buildHalfPalindrome(0, true, halfPart, freq, length, target)) {
            return "";
        }

        int mirrorStart = halfPart.length() - 1 - (length % 2);
        while (mirrorStart >= 0) {
            halfPart.append(halfPart.charAt(mirrorStart--));
        }

        return halfPart.toString();
    }

    public boolean buildHalfPalindrome(int idx, boolean targetPrefix, StringBuilder half, int[] freq, int len, String target) {

        if (idx == (len + 1) / 2) {
            return isPalindromeGreater(len, half.toString(), target);
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            int i = ch - 'a';

            if (targetPrefix) {
                if (ch >= target.charAt(idx) &&
                    (freq[i] >= 2 ||
                     (freq[i] >= 1 && isMiddle(idx, len)))) {

                    half.append(ch);
                    freq[ch - 'a'] -= isMiddle(idx, len) ? 1 : 2;
                    boolean nextMatch = ch == target.charAt(idx);

                    if (buildHalfPalindrome(idx + 1, nextMatch, half, freq, len, target)) {
                        return true;
                    }

                    freq[ch - 'a'] += isMiddle(idx, len) ? 1 : 2;
                    half.deleteCharAt(half.length() - 1);
                }
            } else {
                if (freq[i] >= 2 || (freq[i] >= 1 && isMiddle(idx, len))) {
                    half.append(ch);
                    freq[ch - 'a'] -= isMiddle(idx, len) ? 1 : 2;

                    if (buildHalfPalindrome(idx + 1, false, half, freq, len, target)) {
                        return true;
                    }

                    freq[ch - 'a'] += isMiddle(idx, len) ? 1 : 2;
                    half.deleteCharAt(half.length() - 1);
                }
            }
        }

        return false;
    }

    public boolean isPalindromeGreater(int len, String half, String target) {
        StringBuilder fullPalindrome = new StringBuilder(half);
        int mirrorStart = half.length() - 1 - (len % 2);
        while (mirrorStart >= 0) {
            fullPalindrome.append(half.charAt(mirrorStart--));
        }
        return fullPalindrome.toString().compareTo(target) > 0;
    }

    public boolean isMiddle(int idx, int len) {
        return (len % 2 == 1 && idx == (len / 2));
    }
}
