class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else if(map.containsKey(arr[i])){
                int key = map.get(arr[i])+1;
                 map.put(arr[i],key);
            }
        }
        int a = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        for(int i =0; i<arr.length;i++){
          int v = map.get(arr[i]);
          if(v==1){
            arr1.add(arr[i]);
          }
        }
       if(k<=arr1.size()){ 
            return arr1.get(k-1);
       }
       return "";
    }
}