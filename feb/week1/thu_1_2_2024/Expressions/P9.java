public class P9 {
    public static void main(String[] args) {
        float a=3,b=5,c=4;
        System.out.println( "area of triangale is "+areaOfTri(a, b, c));
    }
    static float areaOfTri(float a,float  b,float c){
        float s=(a+b+c)/2;
        return (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
