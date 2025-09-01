class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int row[]: classes){
            double p = row[0], q = row[1];
            double gain = ((p+1)/(q+1)) - (p/q);
            pq.offer(new double[]{gain, p, q});
        }
        while(extraStudents > 0){
            double row[] = pq.poll();
            double p = row[1]+1, q = row[2]+1;
            double gain = ((p+1)/(q+1)) - (p/q);
            pq.offer(new double[]{gain, p, q});
            extraStudents--;
        }
        double sum = 0;
        while(!pq.isEmpty()){
            double arr[] = pq.poll();
            sum += arr[1]/arr[2];
        }
        return sum/classes.length;
    }
}