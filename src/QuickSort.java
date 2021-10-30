public class QuickSort {
    public static boolean containsDuplicate(int[] a) {

        quicksort(a);
        int n = a.length;
        int i;

        for (i = 0; i < n - 1; i++) {
            if (a[i + 1] == a[i]) {
                return true;
            }
        }
        return false;
    }

    public static void sort(int[] a, int low, int high) {

        int i, j, index;
        if (low > high) {
            return;
        }
        i = low;  // i = 0
        j = high; // j = n - 1
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] < index)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        sort(a, low, i - 1);  // sort(a,0,i-1)
        sort(a, i + 1, high);  // sort(a,i+1,n-1)
    }

    public static void quicksort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
}
