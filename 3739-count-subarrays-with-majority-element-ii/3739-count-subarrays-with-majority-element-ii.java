class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int prefix[] = new int[n+1];

        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + ((nums[i] == target) ? 1 : -1);
        }

        int temp[] = new int[n+1];
        return mergeSort(prefix, temp, 0, n);
    }
    public long mergeSort(int prefix[], int temp[], int left, int right){
        if(left >= right) return 0;
        long count = 0;

        int mid = left + (right-left)/2;
        count += mergeSort(prefix, temp, left, mid);
        count += mergeSort(prefix, temp, mid+1, right);

        count += merge(prefix, temp, left, mid, right);
        return count;
    }
    public long merge(int prefix[], int temp[], int left, int mid, int right){
        long count = 0;
        int j = mid+1;
        for(int i=left; i<=mid; i++){
            while(right >= j && prefix[i] >= prefix[j]){
                j++;
            }
            count += (right - j + 1);
        }

        int i = left;
        j = mid+1;
        int k = left;
        while(i <= mid && j <= right){
            if(prefix[i] >= prefix[j]){
                temp[k] = prefix[j];
                k++; j++;
            } else {
                temp[k] = prefix[i];
                k++; i++;
            }
        }

        while(i<=mid){
            temp[k] = prefix[i];
            k++; i++;
        }

        while(j <= right){
            temp[k] = prefix[j];
            k++; j++;
        }

        for(int p=left; p<=right; p++){
            prefix[p] = temp[p];
        }

        return count;

    }
}