public class P5 {
    public static void main(String[] args) {
        if (isEven(6)) {
            System.out.println("number 6 is even");
        }
        else
        System.out.println("number 6 is odd");
    }
    static boolean isEven(int n){
        return n%2==0;
    }
}
