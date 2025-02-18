class Solution {
    public String smallestNumber(String pattern) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            list.add(i);
            visited[i] = true;
            if (solve(pattern, list, visited, 0)) {
                StringBuilder sb = new StringBuilder();
                for (int num : list) {
                    sb.append(num);
                }
                return sb.toString();
            }
            list.remove(list.size() - 1);
            visited[i] = false;
        }
        return "";
    }

    public boolean solve(String s, List<Integer> list, boolean[] visited, int idx) {
        if (idx == s.length()) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;

            if ((s.charAt(idx) == 'I' && list.get(idx) < i) || 
                (s.charAt(idx) == 'D' && list.get(idx) > i)) {

                list.add(i);
                visited[i] = true;

                if (solve(s, list, visited, idx + 1)) {
                    return true;
                }

                list.remove(list.size() - 1);
                visited[i] = false; 
            }
        }
        return false;
    }
}
