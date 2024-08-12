class Solution {
    public String reverseVowels(String s) {
        char c[] = s.toCharArray();
        int p = 0;
        int q = c.length-1;
        String vowels = "aeiouAEIOU";
        while(p<q){
            while(p<q && vowels.indexOf(c[p]) == -1){
                p++;
            }
            while(p<q && vowels.indexOf(c[q]) == -1){
                q--;
            }
            swap(c, p, q);
            p++;
            q--;
        }      
        String s1 = new String(c);
        return s1;
    }
    public void swap(char c[], int i, int j){
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }
}