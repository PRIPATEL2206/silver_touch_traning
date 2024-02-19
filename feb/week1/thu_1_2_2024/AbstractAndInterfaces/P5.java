public class P5 {
    
}
interface A1{
    void p1();
}
interface A2{
    void p2();
}
interface A3{
    void p3();
}
class A implements A1,A2, A3 {

    @Override
    public void p3() {
        System.out.println("p1");
    }

    @Override
    public void p2() {
        System.out.println("p2");
    }

    @Override
    public void p1() {
        System.out.println("p3");
    }
}
