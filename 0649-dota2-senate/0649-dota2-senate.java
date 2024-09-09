class Solution {
    public String predictPartyVictory(String senate) {
        Queue <Integer> radiant = new LinkedList<>();
        Queue <Integer> dire = new LinkedList<>();
        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int ridx = radiant.poll();
            int didx = dire.poll();

            if(ridx < didx){
                radiant.add(ridx + senate.length());
            } else {
                dire.add(didx + senate.length());
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}