class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) return -1;
        char geneChars[] = {'A','C','G','T'};
        Queue <String> q = new LinkedList<>();
        q.add(startGene);
        Set <String> visited = new HashSet<>();
        visited.add(startGene);
        int mutations = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String s = q.poll();
                if(s.equals(endGene)){
                    return mutations;
                }
                char arr[] = s.toCharArray();
                for(int j=0; j<8; j++){
                    char originalChar = arr[j];
                    for(char c: geneChars){
                        if(c == originalChar) continue;
                        arr[j] = c;
                        String str = new String(arr);
                        if(geneBank.contains(str) && !visited.contains(str)){
                            q.offer(str);
                            visited.add(str);
                        }
                    }
                    arr[j] = originalChar;
                }
            }
            mutations++;
        }
        return -1;
    }
}