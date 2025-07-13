class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0; int j=0; int cnt =0;
        while(j<trainers.length && i<players.length){
            int player = players[i];
            if(player <= trainers[j]){
                cnt++; i++;
            }
            j++;
        }
        return cnt;
    }
}