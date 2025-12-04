class Solution {
    public int countCollisions(String directions) {
        Stack <Character> stk = new Stack<>();
        int cnt = 0; stk.push(directions.charAt(0));
        for(int i=1; i<directions.length(); i++){
            char c = directions.charAt(i);
            if(c == 'L' && stk.peek() == 'R'){
                cnt += 2;
                stk.pop(); c = 'S';
            } else if(stk.peek() == 'S' && c == 'L'){
                cnt += 1;
                c = 'S';
            }
            while(!stk.isEmpty() && c == 'S' && stk.peek() == 'R'){
                cnt += 1; stk.pop();
            }
            stk.push(c);
        }
        return cnt;
    }
}