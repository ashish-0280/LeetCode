class Solution {

    public int countTrapezoids(int[][] points) {

        int n = points.length;

        Map<String, List<int[]>> mid = new HashMap<>();
        Map<String, Map<Integer, Integer>> slope = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];

            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];

                String midKey = (p1[0] + p2[0]) + "," + (p1[1] + p2[1]);
                mid.computeIfAbsent(midKey, k -> new ArrayList<>()).add(new int[]{i, j});

                String slopeKey = getSlope(p1, p2);

                slope.putIfAbsent(slopeKey, new HashMap<>());

                Map<Integer, Integer> map = slope.get(slopeKey);

                if (!map.containsKey(i)) {
                    map.put(i, i);
                    map.put(j, i);
                } else {
                    map.put(j, map.get(i));
                }
            }
        }

        int result = 0;

        for (Map<Integer, Integer> map : slope.values()) {

            Map<Integer, Integer> counts = new HashMap<>();
            for (int rep : map.values()) {
                counts.merge(rep, 1, Integer::sum);
            }

            int prevPairs = 0;
            for (int cnt : counts.values()) {
                int currPairs = cnt * (cnt - 1) / 2;
                result += prevPairs * currPairs;
                prevPairs += currPairs;
            }
        }

        for (List<int[]> segList : mid.values()) {

            if (segList.size() <= 1) continue;

            Map<String, Integer> slopeCount = new HashMap<>();

            for (int[] seg : segList) {
                int[] p1 = points[seg[0]];
                int[] p2 = points[seg[1]];
                String key = getSlope(p1, p2);
                slopeCount.merge(key, 1, Integer::sum);
            }

            int prev = 0;
            for (int cnt : slopeCount.values()) {
                result -= prev * cnt;
                prev += cnt;
            }
        }

        return result;
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private String getSlope(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];

        if (dx == 0) return "vertical";
        if (dy == 0) return "horizontal";

        int x = Math.abs(dx);
        int y = Math.abs(dy);
        int g = gcd(x, y);

        String sign = (dx * dy > 0 ? "+" : "-");
        return (x / g) + sign + (y / g);
    }
}
