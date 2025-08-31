class Solution {
    public int score(String[] cards, char x) {
        int left[] = new int[10];
        int right[] = new int[10];
        int xxCount=0;
        int leftCount = 0, rightCount = 0;
        for(String s: cards){
            if(s.charAt(0) == x && s.charAt(1) == x){
                xxCount++;
            } else if(s.charAt(0) == x){
                leftCount++;
                left[s.charAt(1) - 'a']++;
            } else if(s.charAt(1) == x){
                rightCount++;
                right[s.charAt(0) - 'a']++;
            }
        }
        int maxLeft = 0; int maxRight = 0;
        for(int i=0; i<10; i++){
            maxLeft = Math.max(maxLeft, left[i]);
            maxRight = Math.max(maxRight, right[i]);
        }
        int pairLeft = Math.min(leftCount/2, leftCount - maxLeft);
        int leftover = leftCount - 2 * pairLeft;
        int pairRight = Math.min(rightCount/2, rightCount - maxRight);
        leftover += rightCount - 2 * pairRight;

        int ans = pairLeft + pairRight + Math.min(leftover, xxCount);
        if(xxCount > leftover){
            ans += Math.min(pairLeft + pairRight, (xxCount - leftover)/2);
        }
        return ans;
    }
}