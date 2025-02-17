class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        int total = 0;
        subset(tiles, 0, "", set);
        System.out.println(set);
        for(String str: set){
            if(str.length() == 0){
                continue;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
            int n = str.length();
            int factorial = fact(n);
            for(Map.Entry<Character, Integer> entry: map.entrySet()){
                int x = fact(entry.getValue());
                factorial = factorial/x;
            }
            total += factorial;
        }
        return total;
    }
    public int fact(int n){
        if(n == 0){
            return 1;
        }
        return n*fact(n-1);
    }
    public void subset(String s, int idx, String str, HashSet<String> set){
        if(idx == s.length()){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            set.add(sorted);
            return;
        }
        subset(s, idx+1, str+s.charAt(idx), set);
        subset(s, idx+1, str, set);
    }
}