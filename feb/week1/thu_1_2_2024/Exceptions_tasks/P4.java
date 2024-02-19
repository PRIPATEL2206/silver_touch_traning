import java.util.Scanner;

public class P4 {

    public static void main(String[] args) {
      
        try {
            int age= childTakeAge();
        } catch (ValidAgeException e) {
            e.printStackTrace();
        }
    }

    static int childTakeAge() throws ValidAgeException{
        Scanner sc = new Scanner(System.in);
        int age=sc.nextInt();
        sc.close();
        if (age<18) {
            throw new ValidAgeException();
        }        
        return age;
    }

    static int takeAge() throws ValidAgeException{ 
        return childTakeAge();
    }
}
class ValidAgeException extends Exception{
    @Override
    public String toString() {
        return "Valid Age Error : Enter valid age";
    }
}

