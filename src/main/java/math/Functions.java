package math;

public class Functions {
    private static final Decomposable sinSeries = (x, n) -> (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / Series.getFactorial(2 * n + 1);
    private static final Decomposable lnSeries = (x, n) -> (Math.pow(-1, n - 1) * Math.pow(x, n) / n);

    public static double sin(double x) {
        return Series.decomposeToSeries(x, 100, sinSeries);
    }

    public static double cos(double x) {
        return sin(x + Math.PI / 2);
    }

    public static double tan(double x) {
        return sin(x) / cos(x);
    }

    public static double csc(double x) {
        return 1 / sin(x);
    }

    public static double ln(double x) {
        return Series.decomposeToSeries(x, 100, lnSeries);
    }

    public static double log3(double x) {
        return ln(x) / ln(3);
    }

    public static double log5(double x) {
        return ln(x) / ln(5);
    }

    public static double log10(double x) {
        return ln(x) / ln(10);
    }
}
