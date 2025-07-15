class Solution {
    public boolean isValid(String word) {
        int cnt1 = 0; int cnt2 = 0; int cnt=0;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!Character.isLetterOrDigit(ch)) return false;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch =='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                cnt1++;
            } else {
                if(Character.isLetter(ch)){
                    cnt2++;
                }
            }
            
            cnt++;
        }
        if(cnt >= 3 && cnt1 >= 1 && cnt2 >= 1){
            return true;
        }
        return false;
    }
}