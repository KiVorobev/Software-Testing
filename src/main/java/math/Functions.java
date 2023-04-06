package math;

public class Functions {
    public static double sin(double x) {
        return Series.decomposeToSeries(x, Series.sinSeries);
    }

    public static double cos(double x) {
        return 1 - 2 * Math.pow(sin(x / 2), 2);
    }

    public static double tan(double x) {
        return sin(x) / cos(x);
    }

    public static double csc(double x) {
        return 1 / sin(x);
    }

    public static double ln(double x) {
        return Series.decomposeToSeries(x, Series.lnSeries);
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
