class Solution {
    public String decodeString(String s) {
        String currS = "";
        String prevS = "";
        String prevN = "";
        Stack <String> stk = new Stack<>();
        String currN = "";
        String str = "0123456789";
        for(int i=0; i<s.length(); i++){
            if(str.indexOf(s.charAt(i)) != -1){
                currN +=  s.charAt(i);
            } else if(s.charAt(i) == '['){
                stk.push(currS);
                stk.push(currN);
                currS = "";
                currN = "";
            } else if(s.charAt(i) == ']'){
                prevN = stk.pop();
                prevS = stk.pop();
                currS = prevS + currS.repeat(Integer.parseInt(prevN));
            } else {
                currS += s.charAt(i);
            }
        }
        return currS;
    }
}