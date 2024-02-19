

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        System.out.println(n+"^"+r+" = "+pow(n, r));
        sc.close();
    }
    static int pow(int n,int r){
       if(r==0){
        return 1;
       }
       return n*pow(n, r-1);
    }
}
