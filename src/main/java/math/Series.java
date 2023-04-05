package math;

import java.util.function.BiFunction;

public class Series {
    public static final BiFunction<Double, Integer, Double> sinSeries = (x, n) -> (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / Series.getFactorial(2 * n + 1);
    public static final BiFunction<Double, Integer, Double> lnSeries = (x, n) -> (Math.pow(-1, n - 1) * Math.pow(x, n) / n);

    public static double decomposeToSeries(double x, int n, BiFunction<Double, Integer, Double> d) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d.apply(x, i);
        }
        return sum;
    }

    public static long getFactorial(int number) {
        long res = 1;
        for (int i = 2; i <= number; i++) {
            res *= i;
        }
        return res;
    }
}
