class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        int vowelCount = 0; int cnt = 0; String vowel = "aeiouAEIOU";
        for(char ch: word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) return false;
            
            if(Character.isLetter(ch)){
                if(vowel.indexOf(ch) != -1){
                    vowelCount++;
                } else {
                    cnt++;
                }
            }
        }
        if(vowelCount >= 1 && cnt >= 1){
            return true;
        }
        return false;
    }
}