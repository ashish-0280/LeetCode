class Solution {
    public String removeOccurrences(String s, String part) {
        Stack <Character> stk = new Stack<>();
        int n = s.length()-1;
        for(int i=0; i<=n; i++){
            char ch = s.charAt(i);
            stk.push(ch);
            if(ch == part.charAt(part.length()-1)){
                int j=part.length()-1;
                List<Character> list = new ArrayList<>();
                while(j >=0 && !stk.isEmpty() && stk.peek() == part.charAt(j)){
                    list.add(stk.pop());
                    j--;
                }
                if(j != -1){
                    for(int k=list.size()-1; k>=0; k--){
                        stk.push(list.get(k));
                    }
                }
            }
            System.out.println(stk);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}