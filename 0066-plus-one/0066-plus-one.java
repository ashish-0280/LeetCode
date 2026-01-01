class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        int idx = 0;
        if (check(digits)) {
            int arr[] = new int[n + 2];
            arr[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = 0;
            }
            return arr;
        } else {
            if (digits[n] != 9) {
                digits[n]++;
                return digits;
            } else {
                for (int i = n; i >= 0; i--) {
                    if (digits[i] == 9) {
                        digits[i] = 0;
                        idx = i;
                    } else {
                        break;
                    }
                }
            }
            digits[idx - 1]++;
            return digits;
        }
    }

    public boolean check(int nums[]) {
        for (int num : nums) {
            if (num != 9) {
                return false;
            }
        }
        return true;
    }
}