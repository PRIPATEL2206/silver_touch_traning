import java.util.Scanner;

public class P6 {

    public static void main(String[] args) {
      
        try {
            int age= takeAge();
        } catch (ValidAgeException e) {
            e.printStackTrace();
        }
    }

    static int takeAge() throws ValidAgeException{
        Scanner sc = new Scanner(System.in);
        int age=sc.nextInt();
        sc.close();
        if (age<18) {
            throw new ValidAgeException();
        }        
        return age;
    }
}
class ValidAgeException extends Exception{
    @Override
    public String toString() {
        return "Valid Age Error : Enter valid age";
    }
}

