class Solution {
    public String removeStars(String s) {
        String ans = "";
        Stack <Character> stk = new Stack<>();
        int cnt = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '*'){
                cnt++;
            }
            else if(s.charAt(i) != '*' && cnt > 0){
                cnt--;
            }
            else if(cnt == 0){
                stk.push(s.charAt(i));
            }
        }
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
}