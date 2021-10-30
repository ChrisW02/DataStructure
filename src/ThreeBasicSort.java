public class ThreeBasicSort {

    void bubbleSort(int[] a) {
        int n = a.length;
        int i, j, temp;
        boolean flag = true;
        for (i = 1; flag && (i < n); i++) {
            flag = false;
            for (j = 0; j < n - i; j++)
                if (a[j + 1] < a[j]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
        }
    }

    void insertionSort(int[] a) {
        int i, j, key, n = a.length;
        for (i = 1; i < n; i++) {
            key = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] <= key) break;
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
        }
    }

    void selectionSort(int[] a) {
        int n = a.length;
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) min = j;
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}


