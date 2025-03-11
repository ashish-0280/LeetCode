class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        if(s.length() < 3){
            return 0;
        }
        int arr[] = new int[3];
        int j = 0; int i = 0;
        while(j<3){
            if(s.charAt(j) == 'a'){
                arr[0]++;
            } else if(s.charAt(j) == 'b'){
                arr[1]++;
            } else {
                arr[2]++;
            }
            j++;
        }
        while(i < s.length()-2){
            while(j<=s.length()){
                if(check(arr)){
                    cnt += s.length()-j+1;
                    System.out.println(cnt);
                    System.out.println(j);
                    break;
                }
                if(j==s.length()) break;
                char ch = s.charAt(j);
                if(ch == 'a'){
                    arr[0]++;
                } else if(ch == 'b'){
                    arr[1]++;
                } else {
                    arr[2]++;
                }
                j++;
            }
            if(s.charAt(i) == 'a'){
                arr[0]--;
            } else if(s.charAt(i) == 'b'){
                arr[1]--;
            } else {
                arr[2]--;
            }
            i++;
        }
        return cnt;
    }
    public boolean check(int arr[]){
        if(arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1){
            return true;
        }
        return false;
    }
}