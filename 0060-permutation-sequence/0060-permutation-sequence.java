class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        numbers.add(n);

        k--; 
        StringBuilder result = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int index = k / factorial; 
            result.append(numbers.get(index));
            numbers.remove(index);
            if (i > 1) {
                k %= factorial;
                factorial /= (i - 1);
            }
        }

        return result.toString();
    }
}