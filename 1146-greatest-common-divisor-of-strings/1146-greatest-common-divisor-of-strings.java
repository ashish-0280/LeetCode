class Solution {
    public String gcdOfStrings(String str1, String str2) {
       int n = str1.length();
       int m = str2.length();
       String s = "";
       if(n>=m){
        for(int i=m; i>0; i--){
            String sub = str2.substring(0, i);
            s = "";
            while(s.length()<str1.length()){
                s += sub;
            }
            if(s.equals(str1) && gcd(str2, sub)){
                return sub;
            }
        }

       } else {
            for(int i=n; i>0; i--){
            String sub = str1.substring(0, i);
            s = "";
            while(s.length()<str2.length()){
                s += sub;
            }
            if(s.equals(str2) && gcd(str1, sub)){
                return sub;
            }
        }
       }
       return "";
    }
    public boolean gcd(String s, String sub) {
       int i=0; 
       String s2 = "";
       while(s2.length()<s.length()){
        s2 += sub;
        if(s2.equals(s)){
            return true;
        }
       }
       return false;
    }
}