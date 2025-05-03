class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        for(int i=1; i<7; i++){
            int rotation = check(i, tops, bottoms);
            if(rotation != -1){
                return rotation;
            }
        }
        return -1;
    }
    public int check(int x, int tops[], int bottoms[]){
        int rotationTop = 0; int rotationBottom = 0;
        for(int i=0; i<tops.length; i++){
            if(tops[i] != x && bottoms[i] != x){
                return -1;
            } else if(tops[i] != x){
                rotationTop++;
            } else if(bottoms[i] != x){
                rotationBottom++;
            }
        }
        return Math.min(rotationTop, rotationBottom);
    }
}