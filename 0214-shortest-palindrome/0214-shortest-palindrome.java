class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s;
        }
        HashMap <String, Boolean> map = new HashMap<>();
        int n = s.length();
        if(check(s)){
            return s;
        }
        String sl = s.charAt(0) + s;
        if(check(sl)){
            return sl;
        }
        boolean flag = false;
        int endIdx = 0;
        String str1 = "";
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>1; i--){
            endIdx = i;
            String str = s.substring(0,endIdx);
            if(map.containsKey(str)){
                flag = map.get(str);
            } else {
                flag = check(str);
                //map.put(str, flag);
            }
            if(flag){
                break;
            }
        }
        if(flag){
            str1 = reverse(s.substring(endIdx, n));
            sb.append(str1);
            sb.append(s);
            return sb.toString();
        } else {
            String m = reverse(s.substring(1, n));
            sb.append(m);
            sb.append(s);
            return sb.toString();
        }
    }
    public boolean check(String s){
        int i=0; int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String reverse(String str){
        String st = "";
        for(int k=str.length()-1; k>=0; k--){
            st += str.charAt(k);
        }
        return st;
    }
}