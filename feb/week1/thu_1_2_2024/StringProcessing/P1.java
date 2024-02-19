import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] vovel={'a','e','i','o','u'};
        String s=sc.nextLine();
        int cont=0;

        for (int i = 0; i < s.length(); i++) {
            boolean isNotVovel=true;
            for (int j = 0; j < vovel.length; j++) {
                if (s.charAt(i)==vovel[j]) {
                    isNotVovel=false;
                    break;
                }
            }
            if (!isNotVovel) {
                cont+=1;
            }

        }
        System.out.println("number of vovvels are "+cont);
        sc.close();
        
    }
}
