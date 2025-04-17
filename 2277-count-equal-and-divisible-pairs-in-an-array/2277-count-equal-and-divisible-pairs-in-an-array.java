import java.util.*;

class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cnt = 0;

        // Group indices by value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }

        // For each group with same value
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int idx1 = indices.get(i);
                    int idx2 = indices.get(j);
                    if ((idx1 * idx2) % k == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
