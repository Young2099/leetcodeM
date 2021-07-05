package thread;

public class EndThread {
    public static void main(String[] args) {
        UseThread t = new UseThread("name");


        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();

    }

    static class UseThread extends Thread {
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();

            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "is run");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("flag---" + interrupted());
                interrupt();
                e.printStackTrace();
            }finally {
                System.out.println("------------EDN");
            }

            System.out.println("flag：：：" + interrupted());
        }
    }
}
