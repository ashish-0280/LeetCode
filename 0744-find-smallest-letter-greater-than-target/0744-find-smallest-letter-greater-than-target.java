class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0; int high = letters.length-1;
        if(target >= letters[high]){
            return letters[0];
        }
        int goal = target-'a'; char ans = letters[0];
        while(low <= high){
            int mid = (low + high)/2;
            int k = letters[mid]-'a';
            if(k > goal){
                ans = letters[mid];
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}