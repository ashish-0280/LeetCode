class Solution {
    public String clearDigits(String s) {
        String str = "";
        String st = "";
        int j = 0;
        Stack <Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        while(!stk.isEmpty()){
            str += stk.pop();
        }
        for(int i=str.length()-1; i>=0; i--){
            st += str.charAt(i);
        }
        return st;
    }
}