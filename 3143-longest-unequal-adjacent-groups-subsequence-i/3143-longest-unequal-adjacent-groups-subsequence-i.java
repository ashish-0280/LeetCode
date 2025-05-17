class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        if(groups[0] == 1) flag = true;
        for(int i=0; i<groups.length; i++){
            if(flag && groups[i] == 1){
                list.add(words[i]);
                flag = false;
            } else if(!flag && groups[i] == 0){
                list.add(words[i]);
                flag = true;
            }
        }
        return list;
    }
}