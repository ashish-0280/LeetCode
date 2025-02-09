class Solution {
    public int myAtoi(String s) {
        int sign = 1, n = s.length(), digit = 0;
        int i = 0;
        
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '+'){
                sign = 1;
            } else {
                sign = -1;
            }
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i) - '0';
            if(digit > (Integer.MAX_VALUE - num) / 10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            digit = digit  * 10 + num;
            i++;
        }
        return sign * digit;
    }
}