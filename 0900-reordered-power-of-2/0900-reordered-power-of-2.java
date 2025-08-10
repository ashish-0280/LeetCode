class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        return backtrack(arr, used, 0, 0);
    }
    public boolean backtrack(char arr[], boolean used[], int idx, int num){
        if (idx == arr.length) {
            return (num & (num-1)) == 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            // Skip leading zero
            if (idx == 0 && arr[i] == '0') continue;
            // Skip duplicates in same position
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;

            used[i] = true;
            if (backtrack(arr, used, idx + 1, num * 10 + (arr[i] - '0')))
                return true;
            used[i] = false;
        }
        return false;

    }
}