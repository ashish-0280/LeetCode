class Solution {
    public int getLeastFrequentDigit(int n) {
        String s = String.valueOf(n);
        int freq[] = new int[10];
        for(char c: s.toCharArray()){
            freq[c-'0']++;
        }
        int minFreq = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<10; i++){
            if(freq[i] > 0){
                if(freq[i] < minFreq){
                    minFreq = freq[i];
                    min =i;
                } else if(freq[i] == minFreq && min > i){
                    min = i;
                }
            }
        }
        return min;
    }
}