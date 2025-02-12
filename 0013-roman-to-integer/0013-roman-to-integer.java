class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        int digit = 0;
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            int num = map.get(ch);
            if(i>0){
                if(ch == 'V' && s.charAt(i-1) == 'I'){
                    num = 4; i--;
                } else if(ch == 'X' && s.charAt(i-1) == 'I'){
                    num = 9; i--;
                } else if(ch == 'L' && s.charAt(i-1) == 'X'){
                    num = 40; i--;
                } else if(ch == 'C' && s.charAt(i-1) == 'X'){
                    num = 90; i--;
                } else if(ch == 'D' && s.charAt(i-1) == 'C'){
                    num = 400; i--;
                } else if(ch == 'M' && s.charAt(i-1) == 'C'){
                    num = 900; i--;
                }
            }
            digit += num;
        }
        return digit;
    }
}