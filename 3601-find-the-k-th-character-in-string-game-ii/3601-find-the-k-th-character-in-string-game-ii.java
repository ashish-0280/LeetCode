class Solution {
    public char kthCharacter(long k, int[] operations) {
       if(k==1){
        return 'a';
       }
       long len = 1;
       long newk = 0;
       int type = 0;
       int n = operations.length;
       for(int i =0; i<operations.length; i++){
        len*=2;
        if(len>=k){
            type = operations[i];
            newk = k-(len/2);
            break;
        }
       }
       char c = kthCharacter(newk,operations);
       if(c=='z'){
        return 'a';
       }
       if(type == 0){
        return c;
       }
       return (char)(c+1);
    }
}