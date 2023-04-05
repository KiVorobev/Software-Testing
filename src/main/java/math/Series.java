package math;

import java.util.function.DoubleBinaryOperator;

public class Series {
    public static final DoubleBinaryOperator sinSeries = (x, n) -> (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / Series.getFactorial((int) (2 * n + 1));
    public static final DoubleBinaryOperator lnSeries = (x, n) -> (Math.pow(-1, n - 1) * Math.pow(x, n) / n);

    public static double decomposeToSeries(double x, int n, DoubleBinaryOperator d) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d.applyAsDouble(x, i);
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
