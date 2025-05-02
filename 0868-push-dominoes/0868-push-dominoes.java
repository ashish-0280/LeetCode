class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char arr[] = dominoes.toCharArray();
        int forces[] = new int[n]; int force = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'R'){
                force = n;
            } else if(arr[i] == 'L'){
                force = 0;
            } else if(force > 0){
                force--;
            }
            forces[i] += force;
        }
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] == 'L'){
                force = n;
            } else if(arr[i] == 'R'){
                force = 0;
            } else if(force > 0){
                force--;
            }
            forces[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<forces.length; i++){
            if(forces[i] < 0){
                sb.append('L');
            } else if(forces[i] > 0){
                sb.append('R');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}