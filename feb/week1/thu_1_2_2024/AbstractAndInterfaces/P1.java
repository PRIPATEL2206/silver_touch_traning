public class P1 {
    public static void main(String[] args) {

    }
}
abstract class Shape  {
    abstract float calculateArea();
    abstract float calculatePerimeter();
}
class  Circle extends Shape {
    int r;
    Circle(int r){
        this.r=r;
    }
    @Override
    float calculateArea() {
        return (float)Math.PI*r*r;
    }

    @Override
    float calculatePerimeter() {
        return  2*(float)Math.PI*r;
    }
}
class  Rectangle  extends Shape {
    int a,b;
    Rectangle (int a,int b){
        this.a=a;
        this.b=b;
    }
    @Override
    float calculateArea() {
        return a*b;
    }

    @Override
    float calculatePerimeter() {
        return  2*(a+b);
    }
}