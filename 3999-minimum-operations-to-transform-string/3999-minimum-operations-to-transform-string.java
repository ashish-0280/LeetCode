class Solution {
    public int minOperations(String s) 
    {
        int freq[]=new int[26];
        for(char c:s.toCharArray())
        {
            freq[c-'a']++;
        }

        int max=0,prev=26;
        for(int i=freq.length-1;i>0;i--)
        {
            if(freq[i]>0)
            {
                max+=(prev-i);
                prev=i;
            }
        }

        return max;
    }
}