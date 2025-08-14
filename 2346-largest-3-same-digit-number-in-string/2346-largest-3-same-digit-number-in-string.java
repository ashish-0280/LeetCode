class Solution {
    public String largestGoodInteger(String num) {
        if(num.length() < 3) return "";
        for(int i=9; i>=0; i--){
            String str = "" + i + i + i;
            if(num.indexOf(str) != -1){
                return str;
            }
        }
        return "";
    }
}