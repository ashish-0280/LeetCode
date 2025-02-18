class Solution {
    public String smallestNumber(String pattern) {
        List<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[10];
        for(int i=1; i<=9; i++){
            vis[i] = true;
            list.add(i);
            System.out.println(list);
            if(solve(pattern, list, 0, vis)){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<list.size(); j++){
                    sb.append(String.valueOf(list.get(j)));
                }
                return sb.toString();
            }
            vis[i] = false;
            list.remove(list.size()-1);
        }
        return "";
    }
    public boolean solve(String s, List<Integer> list, int idx, boolean vis[]){
        if(idx >= s.length()){
            return true;
        }
        for(int i=1; i<=9; i++){
            if(vis[i]){
                continue;
            }
            if((s.charAt(idx) == 'I' && list.get(idx) < i) || (s.charAt(idx) == 'D' && list.get(idx) > i)){
                vis[i] = true;
                list.add(i);
                if(solve(s, list, idx+1, vis)){
                    return true;
                }
                vis[i] = false;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}