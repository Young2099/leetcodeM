package thread;

import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class OnlyMain {
    public static void main(String[] args) {
        UseRun useRun = new UseRun();
        Thread t = new Thread(useRun);
        t.start();
        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        new Thread(futureTask).start();
    }

    static class UseRun implements Runnable {

        @Override
        public void run() {

        }
    }

    static class UseCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
