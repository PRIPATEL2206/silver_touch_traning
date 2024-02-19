public class P3 {
    public static void main(String[] args) {
        int b=4;
        try {
            System.out.println("some statment which can have errors");
            int a=1/0;
        } catch (Exception e) {
            System.out.println("this will execute if any error accor error is "+e);
        }finally{
            System.out.println("this will execute error accor or not accor");
            System.out.println("value of b is "+b);
        }
    }
}
