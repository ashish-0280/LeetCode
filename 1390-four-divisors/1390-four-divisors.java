class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;

        for (int num : nums) {
            int cnt = 0;
            int sum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int other = num / i;

                    sum += i;
                    cnt++;

                    if (i != other) {
                        sum += other;
                        cnt++;
                    }

                    if (cnt > 4) {
                        break;
                    }
                }
            }

            if (cnt == 4) {
                total += sum;
            }
        }

        return total;
    }
}
