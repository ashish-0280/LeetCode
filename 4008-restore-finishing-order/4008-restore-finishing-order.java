class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int ans[] = new int[friends.length];
        int i = 0;
        for(int num: order){
            if(isFriend(num, friends)){
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
    public boolean isFriend(int x, int friends[]){
        int i=0; int j=friends.length-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(friends[mid] == x){
                return true;
            } else if(friends[mid] < x){
                i = mid+1;
            } else {
                j = mid-1;
            }
        }
        return false;
    }
}