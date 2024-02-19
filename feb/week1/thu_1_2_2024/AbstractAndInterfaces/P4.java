public class P4 {
    
}
interface Resizable {
    void resize();
}
class ResizableCircle implements Resizable{

    @Override
    public void resize() {
        System.out.println("Circule is resized");
    }

}