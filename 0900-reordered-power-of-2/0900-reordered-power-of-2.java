class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sort(n);
        for(int i=0; i<31; i++){
            String power = sort(1<<i);
            if(target.equals(power)){
                return true;
            }
        }
        return false;
    }
    public String sort(int n){
        char arr[] = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}