class Solution {
    public List<String> letterCombinations(String digits) {
        List <String> list = new ArrayList<>();
        List <String> list2 = new ArrayList<>();
        if(digits.equals("")){
            return new ArrayList<>();
        }
        HashMap <Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for(int i=0; i<digits.length(); i++){
            list.add(map.get(digits.charAt(i)));
        }
        String str = "";
        solve(list,0 ,list2, str);
        return list2;
    }
    public void solve(List<String> list, int idx, List <String> list2, String str){
        if(idx >= list.size()){
            list2.add(str);
            return;
        }
        for(int j=0; j<list.get(idx).length(); j++){
            solve(list, idx+1, list2, str + list.get(idx).charAt(j));

        }
    }
}