class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0;
        int x = 0;
        int y = 0, maxDis = 0;
        HashSet <String> set = new HashSet<>();
        for(int[] obstacle: obstacles){
            set.add(obstacle[0]+","+obstacle[1]);
        }
        for(int command: commands){
            if(command == -1){
                dir = (dir+1)%4;
            } else if(command == -2){
                dir = (dir+3)%4;
            } else {
                for(int k=0; k<command; k++){
                    int nextStepX = x + direction[dir][0];
                    int nextStepY = y + direction[dir][1];

                    if(!set.contains(nextStepX+","+nextStepY)){
                        x = nextStepX;
                        y = nextStepY;
                        maxDis = Math.max(maxDis, x*x+y*y);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxDis;
    }
}