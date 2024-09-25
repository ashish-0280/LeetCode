class Solution {
    private List<List<Integer>> rooms;
    private Set<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms; 
        visited = new HashSet<>();
        dfs(0); 
        return visited.size() == rooms.size();
    }

    
    private void dfs(int roomIndex) {
        
        if (visited.contains(roomIndex)) {
            return;
        }
    
        visited.add(roomIndex);
        for (int nextRoomIndex : rooms.get(roomIndex)) {
            dfs(nextRoomIndex);
        }
    }
}