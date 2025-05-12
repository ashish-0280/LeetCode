class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: digits){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num=100; num<1000; num++){
            if(num % 2 == 0 && solve(map, num)){
                set.add(num);
            }
        }
        int ans[] = new int[set.size()];
        int i=0;
        for(int item: set){
            ans[i] = item;
            i++;
        }
        Arrays.sort(ans);
        return ans;
    }
    public boolean solve(HashMap<Integer, Integer> map, int num){
        List<Integer> list = new ArrayList<>(); int i=0;
        int digit = num;
        while(digit > 0){
            int rem = digit % 10;
            if(num == 200 || num == 198){
            }
            if(!map.containsKey(rem)){
                for(int n: list){
                    map.put(n, map.getOrDefault(n,0)+1);
                }
                return false;
            }
            map.put(rem, map.get(rem)-1);
            if(map.get(rem) == 0){
                map.remove(rem);
            }
            list.add(rem);
            digit = digit/10;
        }
        for(int n: list){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        return true;
    }
}