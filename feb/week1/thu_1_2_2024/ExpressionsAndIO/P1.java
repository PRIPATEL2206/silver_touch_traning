import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        System.out.println("enter options");
         Scanner sc = new Scanner(System.in);
         while (true) {
            System.out.println("1: for calcius to farenheat"); 
            System.out.println("2: for calcius to farenheat"); 
            System.out.println("q: for exit"); 
            System.out.println("okodnjd");
            String c=sc.nextLine();
            switch (c) {
                case "1":
                System.out.println("enter celcius");
                    int ce=sc.nextInt();
                    System.out.println("farenheat is :"+fToC(ce));
                    break;
                    case "2":
                    System.out.println("enter celcius");
                        int fe=sc.nextInt();
                        System.out.println("farenheat is :"+cToF(fe));
                    break;
                case "q":
                    break;
            
                default:
                    break;
            }
            if (c=="q") {
                break;
            }
        }
        sc.close();
    }

    static float fToC(float f) {
        return (f - 32) * 5 / 9;
    }

    static float cToF(float c) {
        return c * 9 / 5 + 32;
    }
}
