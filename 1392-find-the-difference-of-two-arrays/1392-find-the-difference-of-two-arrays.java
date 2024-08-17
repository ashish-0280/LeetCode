class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet <Integer> set = new HashSet<>();
        for(int num: nums2){
            set.add(num);
        }
        list.add(new ArrayList<Integer>());
        for(int i=0; i<nums1.length; i++){
            if(!set.contains(nums1[i])){
                list.get(0).add(nums1[i]);
                set.add(nums1[i]);
            }
        }
        set.clear();
        for(int num: nums1){
            set.add(num);
        }
        list.add(new ArrayList<Integer>());
        for(int i=0; i<nums2.length; i++){
            if(!set.contains(nums2[i])){
                list.get(1).add(nums2[i]);
                set.add(nums2[i]);
            }
        }
        return list;
    }
}