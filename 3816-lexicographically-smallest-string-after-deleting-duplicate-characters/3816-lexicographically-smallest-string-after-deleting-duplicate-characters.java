class Solution {
    public String lexSmallestAfterDeletion(String s) {
        int[] freq = new int[26];
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char curr : s.toCharArray()) {
            freq[curr - 'a']--;

            while (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                if (last > curr &&
                    (freq[last - 'a'] > 0 || count[last - 'a'] > 1)) {
                    sb.deleteCharAt(sb.length() - 1);
                    count[last - 'a']--;
                } else break;
            }

            sb.append(curr);
            count[curr - 'a']++;
        }
        while (sb.length() > 0) {
            char last = sb.charAt(sb.length() - 1);
            if (count[last - 'a'] > 1) {
                sb.deleteCharAt(sb.length() - 1);
                count[last - 'a']--;
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
