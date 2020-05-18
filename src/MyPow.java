public class MyPow {

    private static double myPow(double x, int n) {
        double res = x;
        double ratio;
        while (n > 1) {
            ratio = n % 2 == 0 ? x : x * x;
            res = res * ratio;
            n /= 2;
        }

        System.err.println(n);
        System.err.println(res);

        return 0D;
    }

    public static void main(String[] args) {
        myPow(2,4);
    }

}
