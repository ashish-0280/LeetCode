class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE; int n = blocks.length();
        int cnt = 0;
        int i=0; int j=0;
        for(int p=0; p<k; p++){
            if(blocks.charAt(p) == 'W'){
                cnt++;
            }
            j = p+1;
        }
        min = Math.min(min, cnt);
        while(j<n){
            if(blocks.charAt(i) == 'W'){
                cnt--;
            }
            if(blocks.charAt(j) == 'W'){
                cnt++;
            }
            min = Math.min(min, cnt);
            i++; j++;
        }
        return min;
    }
}