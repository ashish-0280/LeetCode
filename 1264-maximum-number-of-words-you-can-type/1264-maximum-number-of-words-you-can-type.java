class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String arr[] = text.split(" ");
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char c: brokenLetters.toCharArray()){
            set.add(c);
        }
        for(String s: arr){
            boolean flag = false;
            for(char c: s.toCharArray()){
                if(set.contains(c)){
                    flag = true;  break;
                }
            }
            if(!flag) count++;
        }
        return count;
    }
}