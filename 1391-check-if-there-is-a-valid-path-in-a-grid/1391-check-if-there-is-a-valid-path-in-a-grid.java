import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {

        int dir[][][] = {{{}}, {{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{-1, 0}, {0, 1}}};

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];

            if (r == m - 1 && c == n - 1) return true;
            int num = grid[r][c];
            for (int[] d : dir[num]) {
                int dr = d[0];
                int dc = d[1];

                int nr = r + dr;
                int nc = c + dc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {

                    int next = grid[nr][nc];
                    boolean canConnect = false;
                    for (int[] nextDir : dir[next]) {
                        if (nextDir[0] == -dr && nextDir[1] == -dc) {
                            canConnect = true;
                            break;
                        }
                    }

                    if (canConnect) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }
}