class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        int ans[] = new int[2];
        int i = 0;
        int j = 1;
        int min = Integer.MAX_VALUE;
        Arrays.fill(ans, -1);
        while (j < list.size()) {
            if (list.get(j) - list.get(i) < min) {
                ans[0] = list.get(i);
                ans[1] = list.get(j);
                min = Math.min(min, list.get(j) - list.get(i));
            }
            i++;
            j++;
        }
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}