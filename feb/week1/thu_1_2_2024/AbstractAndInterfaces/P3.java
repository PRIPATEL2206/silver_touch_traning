public class P3 {
    
}
abstract class Animal {
    abstract void makeSound();
    abstract void eat();
}

class Dog extends Animal{

    @Override
    void makeSound() {
        System.out.println("bhau bhau ...");
    }
    
    @Override
    void eat() {
        System.out.println("dog food");
    }

}
class Cat  extends Animal{

    @Override
    void makeSound() {
        System.out.println("miau miau ...");
    }
    
    @Override
    void eat() {
        System.out.println("cat food");
    }

}