class SegmentTree {
    int[] max;

    public SegmentTree(int[] basket) {
        int n = basket.length;
        this.max = new int[4 * n];
        buildTree(1, 0, n - 1, basket);
    }

    private void buildTree(int treeIdx, int left, int right, int[] basket) {
        if (left == right) {
            max[treeIdx] = basket[left];
            return;
        }

        int mid = left + (right - left) / 2;
        buildTree(2 * treeIdx, left, mid, basket);
        buildTree(2 * treeIdx + 1, mid + 1, right, basket);
        updateParent(treeIdx);
    }

    private void updateParent(int treeIdx) {
        max[treeIdx] = Math.max(max[treeIdx * 2], max[treeIdx * 2 + 1]);
    }

    public boolean placeFruit(int treeIdx, int left, int right, int size) {
        if (max[treeIdx] < size) return false;

        if (left == right) {
            max[treeIdx] = -1;
            return true;
        }

        int mid = left + (right - left) / 2;
        boolean placed = placeFruit(treeIdx * 2, left, mid, size);
        if (!placed) placed = placeFruit(treeIdx * 2 + 1, mid + 1, right, size);

        updateParent(treeIdx);
        return placed;
    }
}
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree tree = new SegmentTree(baskets);
        int result = 0;
        for (int fruit : fruits) {
            if (!tree.placeFruit(1, 0, baskets.length - 1, fruit)) result++;
        }
        return result;
    }
}

