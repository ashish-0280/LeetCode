class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long l = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                l++;
            } else if (c == '*') {
                if (l > 0) l--;
            } else if (c == '#') {
                l *= 2;
            } 
            len[i] = l;
        }
        
        if (k < 0 || k >= len[n - 1]) {
            return '.';
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = (i == 0) ? 0 : len[i - 1];
            
            if (c >= 'a' && c <= 'z') {
                if (k == prevLen) {
                    return c;
                }
            } else if (c == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (c == '%') {
                k = prevLen - 1 - k;
            }
        }
        
        return '.';
        
    }
}