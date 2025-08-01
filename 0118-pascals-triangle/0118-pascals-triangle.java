class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList <Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        lists.add(list1);
        if(numRows == 1){
            return lists;
        }
        ArrayList <Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        lists.add(list2);
        if(numRows == 2){
            return lists;
        }
        for(int i=2; i<numRows; i++){
            lists.add(newlist());
            lists.get(i).add(1);
            for(int j=0; j<lists.get(i-1).size()-1; j++){
                lists.get(i).add(lists.get(i-1).get(j)+lists.get(i-1).get(j+1));
            }
            lists.get(i).add(1);
        }
        return lists;
    }
    public List<Integer> newlist(){
        ArrayList <Integer> list = new ArrayList<>();
        return list;
    }
}