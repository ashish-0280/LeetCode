class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.equals(goal)){
            return true;
        }
        String str = "";
        int n = goal.length();
        for(int i=1; i<s.length(); i++){
            str += s.substring(i, n);
            str += s.substring(0, i);
            if(str.equals(goal)){
                return true;
            } else {
                str = "";
            }
        }
        return false;
    }
}