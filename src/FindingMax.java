public class FindingMax {

    int max(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        System.arraycopy(a, 0, b, 0, n);
        while (n > 1) {
            for (int j = 0; j < n / 2; j++)
                b[j] = Math.max(b[j * 2], b[j * 2 + 1]);
            if (n != n / 2 * 2) b[n / 2] = b[n - 1];
            n = (n + 1) / 2;
        }
        return b[0];
    }

    int max(int[] a, int low, int high) {
        if (low >= high) return a[low];
        int mid = low + (high - low) / 2;
        int m1 = max(a, low, mid); // ceiling of n/2
        int m2 = max(a, mid + 1, high); // floor of n/2
        return Math.max(m1, m2);
    }

    int[] maxmin(int[] a, int low, int high) {

        if (low > high) return null;
        int ans[] = new int[2];

        if (high == low) { // base case 1
            ans[0] = ans[1] = high;
            return ans;
        }
        if (high == low + 1) { // base case 2
            ans[0] = (a[low] > a[high]) ? low : high;
            ans[1] = low - ans[0] + high;
            return ans;
        }

        int mid = low + (high-low)/2;
        int[] a1 = maxmin(a,low,mid);
        int[] a2 = maxmin(a,mid+1,high);
        ans[0] = (a[a1[0]] > a[a2[0]])?a1[0]:a2[0];
        ans[1] = (a[a1[1]] > a[a2[1]])?a1[1]:a2[1];
        return ans;
    }
}
