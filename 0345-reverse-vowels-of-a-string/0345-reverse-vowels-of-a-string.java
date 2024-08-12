class Solution {
    public String reverseVowels(String s) {
        String s1 = "";
        char c[] = s.toCharArray();
        int p = 0;
        int q = c.length-1;
        HashSet <Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while(p<=q){
            if(!set.contains(s.charAt(p))){
                p++;
                continue;
            }
            if(!set.contains(s.charAt(q))){
                q--;
                continue;
            }
            swap(c, p, q);
            p++;
            q--;
        }      
        for(int i=0; i<c.length; i++){
            s1 += c[i];
        }
        return s1;
    }
    public void swap(char c[], int i, int j){
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }
}