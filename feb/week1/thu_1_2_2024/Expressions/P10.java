public class P10 {
    public static void main(String[] args) {
        int year=2024;

        if (isLeapYear(year)) {
            System.out.println("2024 is leap year");
        }
        else
            System.out.println("2024 is not leap year ");
    }
    static boolean isLeapYear(int year){
        return year%400==0 ||(year%100!=0 && year%4==0);
    }
}
