class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); int min = Integer.MAX_VALUE; int j = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] - arr[i] < min){
                j = 0; min = arr[i+1] - arr[i];
                list.clear();
                list.add(new ArrayList<>());
                list.get(j).add(arr[i]);
                list.get(j).add(arr[i+1]);
                j++;
            } else if(arr[i+1] - arr[i] == min){
                list.add(new ArrayList<>());
                list.get(j).add(arr[i]);
                list.get(j).add(arr[i+1]);
                j++;
            }
        }
        return list;
    }
}