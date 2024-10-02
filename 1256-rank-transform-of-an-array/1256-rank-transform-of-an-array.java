class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int nums[] = Arrays.copyOf(arr, arr.length);
        Map <Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            map.putIfAbsent(arr[i], map.size() + 1);
        }
        for(int i=0; i<arr.length; i++){
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}