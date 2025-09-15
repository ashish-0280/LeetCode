class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String arr[] = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for(char ch: brokenLetters.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for(String s: arr){
            boolean flag = false;
            for(char ch: s.toCharArray()){
                if(set.contains(ch)){
                    flag = true; break;
                }
            }
            if(!flag) count++;
        }
        return count;
    }
}