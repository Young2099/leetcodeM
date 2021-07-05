package letcodeReview.guihua;

public class IntReset {
    public static void main(String[] args) {
//        int a = new IntReset().reverse(1234);
        int a = 123 ;
        System.out.println(a);
    }

    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            int p = x%10;
            x /= 10;
            res = res*10+p;
        }
        return (int)(res<Math.pow(2,31)-1&&res>Math.pow(-2,31)?res:0);
    }
}
