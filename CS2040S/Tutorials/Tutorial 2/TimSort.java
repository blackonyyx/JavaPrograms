class TimSort{
    public static void main(String[] args){
        int[] arr = new int[]{123,43,23,55,11,59,62,73,29,50};
    }
    /**
     * The run portion of timsort.
     */
    public static void insertionSort( int arr[],int left,int right){
        for (int i = left+1;i<=right;i++){
            int temp = arr[i];
            int j = i-1;
            //while the current index j value is greater than current value and index >= start
            while (arr[j]>temp && j>=left){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void merge(int[] arr, int l, int m, int r){
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int i =0; i<len1;i++){
            left[i] = arr[l+i];
        }
        for (int i = 0;i<len2;i++){
            right[i] = arr[m+i+1];
        }
        int i,j,k;
        k = l;
        i = 0;
        j=0;
        //performs comparisons on left and right
        while (i<len1&&j<len2){
            if (left[i]<=right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<len1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j<len2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void timSort(int[] arr, int n){
        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += 32){
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        // start merging from size RUN (or 32). It will merge
        // to form size 64, then 128, 256 and so on ....
        for (int size = 32; size < n; size = 2 * size){
            // pick starting point of left sub array. We
            // are going to merge arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we increase left by 2*size
            for (int left = 0; left < n; left += 2 * size){
                // find ending point of left sub array
                // mid+1 is starting point of right sub array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                merge(arr, left, mid, right);
            }
        }
    }
}
