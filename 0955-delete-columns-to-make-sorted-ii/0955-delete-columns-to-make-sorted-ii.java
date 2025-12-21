class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt = 0;
        boolean fixed[] = new boolean[strs.length];
        for(int i=0; i<strs[0].length(); i++){
            boolean flag = false;
            int j=0;
            while(j<strs.length-1){
                if(!fixed[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                    flag = true;
                    break;
                }
                j++;
            }
            if(flag){
                cnt++;
                continue;
            }
            j=0;
            while(j<strs.length-1){
                if(!fixed[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
                    fixed[j] = true;
                }
                j++;
            }
        }
        return cnt;
    }
}