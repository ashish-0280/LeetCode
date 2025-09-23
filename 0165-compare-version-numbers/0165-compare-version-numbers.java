class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");
        for(int i=0; i<Math.max(arr1.length, arr2.length); i++){
            int x = 0; int y = 0;
            if(i < arr1.length){
                x = Integer.valueOf(arr1[i]);
            } 
            if(i < arr2.length){
                y = Integer.valueOf(arr2[i]);
            } 
            System.out.println(x + " " + y);
            if(x > y) return 1;
            if(x < y) return -1;
        }
        return 0;
    }
}