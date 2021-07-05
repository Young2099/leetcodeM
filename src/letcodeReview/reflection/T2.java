package letcodeReview.reflection;

import java.lang.reflect.Field;

public class T2 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Class mClass = testClass.getClass();

        try {
            Field field = mClass.getDeclaredField("FINAL_VALUE");
            if (field != null){
                field.setAccessible(true);
                System.out.println(field.get(testClass));
            }
            field.set(testClass,"hello");
            System.out.println(field.get(testClass));
            System.out.println(testClass.getFinalValue());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();

        }
    }

}
