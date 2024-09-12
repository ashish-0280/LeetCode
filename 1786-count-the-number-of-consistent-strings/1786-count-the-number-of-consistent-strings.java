class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        String help = "";
        for(char i='a'; i<='z'; i++){
            String str = String.valueOf(i);
            if(!allowed.contains(str)){
                help += i;
            }
        }
        System.out.println(help);
        int cnt = 0;
        for(String str: words){
            if(check(str, help)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean check(String s, String help){
        for(int i=0; i<s.length(); i++){
            String str = String .valueOf(s.charAt(i));
            if(help.contains(str)){
                return false;
            }
        }
        return true;
    }
}