class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0; int high = letters.length-1;
        if(target >= letters[high]){
            return letters[0];
        }
        int arr[] = new int[high+1];
        for(int i=0; i<high+1; i++){
            arr[i] = letters[i]-'a';
        }
        int goal = target-'a';
        while(low<high){
            int mid = (low + high)/2;
            if(arr[mid] == goal){
                while(mid < arr.length-1 && arr[mid] == arr[mid+1]){
                    mid++;
                }
                return letters[mid+1];
            } else if(arr[mid] > goal){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return letters[high];
    }
}