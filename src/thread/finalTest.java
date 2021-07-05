package thread;

public class finalTest {
    private final String name = "10";
    final int i2;

    public finalTest() {
        i2 = 1;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] arg) throws Exception {
        finalTest main = new finalTest();
        System.out.println(main.toString().toLowerCase());
    }
}
