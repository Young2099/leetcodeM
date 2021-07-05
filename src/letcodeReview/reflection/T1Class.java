package letcodeReview.reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T1Class {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        try {
//            Class cls  = Class.forName("java.lang.String");
//            System.out.println(cls.getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Class cls = String.class;
//        String s = (String) cls.newInstance();
//        System.out.println(s.length());
//        Person p = new Person("yang");
//        Class c = p.getClass();
//        try {
//            Field field = c.getDeclaredField("name");
//            field.setAccessible(true);
//            Object value = field.get(p);
//            System.out.println(value);
//            field.set(p,"fang");
//            System.out.println(p.getName());
//
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        Student student = new Student("yang");
//        Class t = student.getClass();
//        try {
//            Method m = t.getMethod("getName");
//            Method method = t.getDeclaredMethod("getGrade", int.class);
//            method.setAccessible(true);
//            int b = (int) method.invoke(student,10);
//            System.out.println(b);
//            System.out.println(m.invoke(student));
//        } catch (NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            //获取构造方法
//            Constructor constructor1 = Integer.class.getConstructor(int.class);
//            //调用构造方法
//            Integer n1 = (Integer) constructor1.newInstance(124);
//            System.out.println(n1);
//            Constructor cons2 = Integer.class.getConstructor(String.class);
//            Integer n2 = (Integer) cons2.newInstance("456");
//            System.out.println(n2);
//        } catch (NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        Class i = Integer.class;
//        Class n = i.getSuperclass();
//        System.out.println(n.getSuperclass());
//
//        Class s = AA.class;

//            Method method = s.getMethod("getA");
//            System.out.println(method.getName());
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);


        }
    }


}
