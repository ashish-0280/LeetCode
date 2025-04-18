class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        } 
        if(n == 2){
            return "11";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("11");
        while(n-2 > 0){
            String s = sb.toString();
            sb.setLength(0); int p=1; char prev = '0';
            for(int i=0; i<s.length(); i++){
                if(i==0){
                    p = 1;
                    prev = s.charAt(0);
                    continue;
                }
                if(prev == s.charAt(i)){
                    p++;
                } else {
                    String st = String.valueOf(p);
                    sb.append(p);
                    sb.append(prev);
                    p = 1;
                }
                if(i == s.length()-1){
                    String st = String.valueOf(p);
                    sb.append(p);
                    sb.append(s.charAt(i));
                }
                prev = s.charAt(i);
            }
            n--;
        }
        return sb.toString();
    }
}