class Solution {
    Map<Long, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int mask = (1 << n) - 1;
        return dfs(mask, n, firstPlayer - 1, secondPlayer - 1, 1);
    }

    private int[] dfs(int mask, int numPlayers, int firstPlayer, int secondPlayer, int round) {
        long key = (((long) mask) << 10) | numPlayers;
        key = (key << 10) | firstPlayer;
        key = (key << 10) | secondPlayer;
        key = (key << 5) | round;
        if (memo.containsKey(key)) return memo.get(key);

        // extract current players
        List<Integer> players = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((mask & (1 << i)) != 0) {
                players.add(i);
            }
        }

        int left = 0, right = players.size() - 1;

        // check if firstPlayer meets secondPlayer this round
        while (left < right) {
            int p1 = players.get(left);
            int p2 = players.get(right);
            if ((p1 == firstPlayer && p2 == secondPlayer) || (p1 == secondPlayer && p2 == firstPlayer)) {
                return memo.computeIfAbsent(key, k -> new int[]{round, round});
            }
            left++;
            right--;
        }

        // try all possible outcomes
        List<int[]> newMasks = new ArrayList<>();
        buildNextMasks(players, 0, players.size() - 1, 0, newMasks, firstPlayer, secondPlayer);

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        for (int[] next : newMasks) {
            int nextMask = 0;
            for (int x : next) {
                nextMask |= (1 << x);
            }
            int[] res = dfs(nextMask, Integer.bitCount(nextMask), firstPlayer, secondPlayer, round + 1);
            minRound = Math.min(minRound, res[0]);
            maxRound = Math.max(maxRound, res[1]);
        }

        int[] ans = new int[]{minRound, maxRound};
        memo.put(key, ans);
        return ans;
    }

    private void buildNextMasks(List<Integer> players, int left, int right, int currentMask,
                                List<int[]> res, int firstPlayer, int secondPlayer) {
        if (left > right) {
            // convert bitmask into player list
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                if ((currentMask & (1 << i)) != 0) {
                    next.add(i);
                }
            }
            res.add(next.stream().mapToInt(Integer::intValue).toArray());
            return;
        }

        if (left == right) {
            int midPlayer = players.get(left);
            buildNextMasks(players, left + 1, right - 1, currentMask | (1 << midPlayer), res, firstPlayer, secondPlayer);
            return;
        }

        int p1 = players.get(left);
        int p2 = players.get(right);

        // if p1 or p2 are firstPlayer/secondPlayer, they always win
        if (p1 == firstPlayer || p1 == secondPlayer) {
            buildNextMasks(players, left + 1, right - 1, currentMask | (1 << p1), res, firstPlayer, secondPlayer);
        } else if (p2 == firstPlayer || p2 == secondPlayer) {
            buildNextMasks(players, left + 1, right - 1, currentMask | (1 << p2), res, firstPlayer, secondPlayer);
        } else {
            // try p1 wins
            buildNextMasks(players, left + 1, right - 1, currentMask | (1 << p1), res, firstPlayer, secondPlayer);
            // try p2 wins
            buildNextMasks(players, left + 1, right - 1, currentMask | (1 << p2), res, firstPlayer, secondPlayer);
        }
    }
}