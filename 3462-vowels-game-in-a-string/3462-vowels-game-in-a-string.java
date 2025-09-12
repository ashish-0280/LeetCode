class Solution {
    public boolean doesAliceWin(String s) {
        int evenCount = 0;
        int oddCount = 0; String vowels = "aeiou"; int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(vowels.indexOf(ch) != -1){
                int j = i;
                while(i<s.length() && vowels.indexOf(s.charAt(i)) != -1){
                    i++;
                }
                if(i-j % 2 == 0){
                    evenCount++;
                } else {
                    oddCount++;
                }
                continue;
            }
            i++;
        }
        if(evenCount >= oddCount){
            return false;
        }
        return true;
    }
}