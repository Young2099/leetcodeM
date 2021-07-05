package letcodeReview.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
    static ThreadLocal<Person> t = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                t.set(new Person("hello"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println(t.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
