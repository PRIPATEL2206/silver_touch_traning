import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towerOfHanoi(n, 'a', 'b', 't');
        sc.close();
    }
    static void towerOfHanoi(int n,char s,char d,char t){
        if (n>0) {
            towerOfHanoi(n-1, s, t, d);
            System.out.println("move "+n+"th ring from "+s+" to "+d);
            towerOfHanoi(n-1, t, d, s);
        }
    }
}
