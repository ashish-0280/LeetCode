class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=9; i++){
            q.add(i);
        }
        int len = 1;
        while(!q.isEmpty() && len < n){
            len++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int curr = q.remove();
                int lastdigit = curr % 10;
                if(lastdigit + k <= 9) q.add(curr*10 + lastdigit + k);
                if(k != 0 && lastdigit - k >= 0) q.add(curr*10 + lastdigit - k);
            }
        }
        while(!q.isEmpty()){
            list.add(q.remove());
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}