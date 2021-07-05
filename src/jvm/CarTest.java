package jvm;

public class CarTest {

    public static void main(String[] args) {
        CarTest carTest = new CarTest();
        System.out.println("ddd"+ carTest.getClass().getClassLoader().getParent().getParent());
    }
}
