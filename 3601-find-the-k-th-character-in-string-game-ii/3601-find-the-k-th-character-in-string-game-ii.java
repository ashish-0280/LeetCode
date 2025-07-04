class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k == 1) return 'a';
        long length = 1;
        int len = operations.length; long idx = 0;
        int operation = operations[0];
        for(int i=0; i<len; i++){
            length = length*2;
            if(length >= k){
                operation = operations[i];
                idx = k-(length/2);
                break;
            }
        }
        char ch = kthCharacter(idx, operations);
        if(operation == 0){
            return ch;
        } else {
            if(ch == 'z') {
                return 'a';
            } else {
                return ++ch;
            }
        }
    }
}