public class P2 {
    
}
interface Drawable {
    void draw();
}
class CircleDrawer implements Drawable{

    @Override
    public void draw() {
        System.out.println("circule is drawed");
    }

}