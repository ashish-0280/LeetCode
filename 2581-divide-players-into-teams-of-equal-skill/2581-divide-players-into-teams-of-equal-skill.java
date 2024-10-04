class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i=0;
        int j = skill.length-1;
        int sum = 0, sum2 = skill[i]+skill[j];
        long ans = 0;
        while(i<=j){
            sum = skill[i] + skill[j];
            if(sum != sum2){
                return -1;
            }
            sum2 = sum;
            ans += skill[i]*skill[j];
            i++;
            j--;
        }
        return ans;
    }
}