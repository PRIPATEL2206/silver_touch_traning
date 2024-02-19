public class P6 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        int n=arr.length;
        float sum=0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println("avrage is "+sum/n);
    }
}
