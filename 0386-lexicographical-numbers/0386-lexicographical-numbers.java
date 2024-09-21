class Solution {
    public List<Integer> lexicalOrder(int n) {
        List <Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a.toString().compareTo(b.toString());
            }
        });
        return list;
    }
}