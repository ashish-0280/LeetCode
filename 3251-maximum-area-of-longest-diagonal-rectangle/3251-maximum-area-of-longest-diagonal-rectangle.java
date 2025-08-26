class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        int max = 0;
        for(int dimension[]: dimensions){
            int diagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if(diagonal > max || (diagonal == max && area < dimension[0] * dimension[1])){
                max = diagonal;
                area = dimension[0] * dimension[1];
            }
        }
        return area;
    }
}