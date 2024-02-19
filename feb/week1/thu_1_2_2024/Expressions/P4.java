public class P4 {
    public static void main(String[] args) {
        
        System.out.println("factorial of  is "+fact(4));
    }
    static int fact(int n){
        int fact =1;
        for (int i = 2; i <=n; i++) {
            fact*=i;
        }
        return fact;
    }
}
