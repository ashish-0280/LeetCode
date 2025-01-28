class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length];
        List<Integer> l = new ArrayList<>();
        Stack <Integer> s = new Stack<>();
        int i=nums2.length-1;
        while(i>=0){
            while(!s.isEmpty() && nums2[s.peek()]<nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                l.add(-1);
            }
            if(!s.isEmpty() && nums2[s.peek()]>=nums2[i]){
                l.add(nums2[s.peek()]);
            }
            s.push(i);
            i--;
        }
        for(int k=0; k<nums1.length; k++){
            int idx = search(nums2, nums1[k]);
            arr[k] = l.get(nums2.length-1-idx);
        }
        return arr;
    }
    public int search(int arr[], int target){
        for(int i=0; i<arr.length; i++){
            if(target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}