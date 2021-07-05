package letcodeReview.reflection;

public class TestClass {
    //String 会被 JVM 优化
    private final String FINAL_VALUE;

    public TestClass(){
        FINAL_VALUE = "FINAL";
    }
    public String getFinalValue() {
        return FINAL_VALUE;
    }
}
