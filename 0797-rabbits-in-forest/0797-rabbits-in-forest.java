class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<answers.length; i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int cnt = 0; 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            int num = key+1;
            int div = val/num; int rem = val%num;
            int total = div * num;
            if(rem != 0){
                total += num;
            }
            cnt += total;
        }
        return cnt;
    }
}