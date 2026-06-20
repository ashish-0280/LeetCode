class Solution {
    public int maxBuilding(int n, int[][] arrtrictions) {
        int m = arrtrictions.length;
        int[][] arr = new int[m + 2][2];
        for (int i = 0; i < m; i++) {
            arr[i] = arrtrictions[i];
        }
        arr[m] = new int[]{1, 0};
        arr[m + 1] = new int[]{n, n - 1};
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int valid = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] != arr[valid - 1][0]) {
                arr[valid++] = arr[i];
            } else {
                arr[valid - 1][1] = Math.min(arr[valid - 1][1], arr[i][1]);
            }
        }
        for (int i = 1; i < valid; i++) {
            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + arr[i][0] - arr[i - 1][0]);
        }
        for (int i = valid - 2; i >= 0; i--) {
            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + arr[i + 1][0] - arr[i][0]);
        }
        int max = 0;
        for (int i = 1; i < valid; i++) {
            int peak = arr[i - 1][1] + (arr[i][0] - arr[i - 1][0] + arr[i][1] - arr[i - 1][1]) / 2;
            max = Math.max(max, peak);
        }
        return max;
    }
}