class Solution {
    public int maxDistance(String moves) {
        int horizontal = 0; int vertical = 0; int count = 0;
        for(char ch: moves.toCharArray()){
            if(ch == 'L'){
                horizontal--;
            } else if(ch == 'R'){
                horizontal++;
            } else if(ch == 'U'){
                vertical++;
            } else if(ch == 'D') {
                vertical--;
            } else {
                count++;
            }
        }
        return Math.abs(horizontal) + Math.abs(vertical) + count;
    }
}