public class P1 {
    public static void main(String[] args) {
        try {
            System.out.println("some statment which can have errors");
            int a=1/0;
        } catch (Exception e) {
            System.out.println("this will execute if any error accor error is "+e);

        }
    }
}
