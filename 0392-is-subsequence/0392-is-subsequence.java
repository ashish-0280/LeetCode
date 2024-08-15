class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        } else if(s.length() == 0){
            return true;
        }
        Stack <Character> stk = new Stack<>();
        for(int i=0; i<t.length(); i++){
            stk.push(t.charAt(i));
        }
        int j = s.length()-1;
        while(!stk.isEmpty()){
            if(j>=0 && stk.peek() == s.charAt(j)){
                j--;
            }
                if(j<0){
                    return true;
                    }
            stk.pop();
        }
        return false;
    }
}