public class MergeSort {


    void mergesort(int[] a, int low, int high) {

        if (high <= low) return;

        int mid = low + (high + low) / 2;

        mergesort(a, low, mid);
        mergesort(a, mid + 1, high);
        mergeV1(a, low, mid, high);
    }
    
    void mergeV1(int[] a, int low, int mid, int high) {
        int[] b = new int[mid - low + 1];
        int[] c = new int[high - mid];
        for (int i = 0; i <= mid - low; i++) {
            b[i] = a[low + i];
        }
        for (int i = 0; i < high - mid; i++) {
            c[i] = a[mid + 1 + i];
        }
        int i1 = 0, i2 = 0, i = low;
        while (i1 < b.length && i2 < c.length) {
            a[i++] = (b[i1] <= c[i2]) ? b[i1++] : c[i2++];
        }
        while (i1 < b.length) a[i++] = b[i1++];
        while (i2 < c.length) a[i++] = c[i2++];
    }
}

//    void mergeArrays(int[] a1, int[] a2, int[] a) {
//
//        int i1 = 0, i2 = 0, i = 0;
//        while (i1 < a1.length && i2 < a2.length) {
//            a[i++] = (a1[i1] <= a2[i2]) ? a1[i1++] : a2[i2++];
//        }
//
//        while (i1 < a1.length) a[i++] = a1[i1++];
//        while (i2 < a2.length) a[i++] = a2[i2++];
//    }