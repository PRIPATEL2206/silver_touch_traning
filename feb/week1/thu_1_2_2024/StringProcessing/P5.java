import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n=s.length();
        char c=sc.nextLine().charAt(0);
        int count =0;
        for (int i = 0; i < n; i++) {
            if (c==s.charAt(i)) {
                count+=1;
            }
        }        
        System.out.println("number of accurence of "+c+" is "+count);
        sc.close();
    }
}
