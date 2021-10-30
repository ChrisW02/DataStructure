public class aaa {
    public static void main(String args[]) {
        int[] arr = {0,0,0};
        int n = 3;
        arr[--n] = n + 1;

        System.out.println(arr[n]);
    }
}
