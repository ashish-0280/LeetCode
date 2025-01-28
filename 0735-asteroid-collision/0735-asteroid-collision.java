class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> s = new Stack<>();
        int n = asteroids.length-1;
        int i=0;
        while(i<=n){
            boolean des = false;
            while(!s.isEmpty() && s.peek()>0 && asteroids[i]<0){
                if(s.peek() < -asteroids[i]){
                    s.pop();
                } else if(s.peek() == -asteroids[i]){
                    s.pop();
                    des = true;
                    break;
                } else {
                    des = true;
                    break;
                }
            }
            if(des == false){
                s.push(asteroids[i]);
            }
            i++;
        }
        int[] ans = new int[s.size()];
        for (int k = s.size() - 1; k >= 0; k--) {
            ans[k] = s.pop();
        }
        return ans;
    }
}