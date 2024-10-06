class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        if (arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        
        int left = 0;
        int right = arr2.length - 1;
        
        while (left < arr2.length && arr1[left].equals(arr2[left])) {
            left++;
        }
        
        while (right >= 0 && arr1[arr1.length - arr2.length + right].equals(arr2[right])) {
            right--;
        }
        
        return left > right;
    }
}
