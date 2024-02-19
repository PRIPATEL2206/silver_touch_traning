import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
      
        try {
            Scanner sc = new Scanner(System.in);
            int age=sc.nextInt();
            sc.close();
            if (age<18) {
                throw new ValidAgeException();
            } 
        } catch (ValidAgeException e) {
            e.printStackTrace();
        }
    }
}
class ValidAgeException extends Exception{
    @Override
    public String toString() {
        return "Valid Age Error : Enter valid age";
    }
}

