class Solution {
    List<Integer> ans = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();

    public int[] minDifference(int n, int k) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i * i != n) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);

        solve(n, k, new ArrayList<>(), 0);
        int res[] = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void solve(int n, int k, List<Integer> current, int idx) {
        if (k == 0) {
            if (n == 1) {
                int maxVal = Collections.max(current);
                int minVal = Collections.min(current);
                int diff = maxVal - minVal;
                
                if (diff < minDiff) {
                    minDiff = diff;
                    ans = new ArrayList<>(current);
                }
            }
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            int div = list.get(i);
            
            if (n % div == 0) {
                current.add(div);
                solve(n / div, k - 1, current, i);
                current.remove(current.size() - 1);
            }
        }
    }
}