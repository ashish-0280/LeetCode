class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0; int high = letters.length-1;
        if(target >= letters[high]){
            return letters[0];
        }
        int goal = target-'a';
        while(low<high){
            int mid = (low + high)/2;
            int k = letters[mid]-'a';
            if(k == goal){
                while(mid < letters.length-1 && k == letters[mid+1]-'a'){
                    mid++;
                }
                return letters[mid+1];
            } else if(k > goal){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return letters[high];
    }
}