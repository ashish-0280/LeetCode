class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String arr[] = text.split(" ");
        int count = 0;
        for(String s: arr){
            boolean flag = false;
            for(char ch: s.toCharArray()){
                if(brokenLetters.indexOf(ch) != -1){
                    flag = true; break;
                }
            }
            if(!flag) count++;
        }
        return count;
    }
}