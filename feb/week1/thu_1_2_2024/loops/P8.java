public class P8 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int n=arr.length;
        System.out.print("array is : ");
        for (int i : arr) {
            System.out.print(i+" , ");
        }
        for (int i = 0; i < n/2; i++) {
            int t=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=t;
        }
        
        System.out.print("\narray is : ");
        for (int i : arr) {
            System.out.print(i+" , ");
        }
        
    }
}
