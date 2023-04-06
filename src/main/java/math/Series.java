package math;

import java.util.function.BiFunction;

public class Series {
    private final double ACCURACY = 0.000001;

    public final BiFunction<Double, Integer, Double> sinSeries = (x, n) -> (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) * getInverseFactorial(2 * n + 1);
    public final BiFunction<Double, Integer, Double> lnSeries = (x, n) -> (n % 2 == 0 ? 0 : (2 * Math.pow((x - 1) / (x + 1), n) / n));

    public double decomposeToSeries(double x, BiFunction<Double, Integer, Double> d) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        double sum = 0;
        double prev = 0;
        double curr = Double.MAX_VALUE;
        int n = 0;
        while (Math.abs(curr - prev) >= ACCURACY) {
            prev = curr;
            curr = d.apply(x, n++);
            sum += curr;
        }
        return sum;
    }

    public double getInverseFactorial(int n) {
        double res = 1;
        for (int i = 1; i <= n; ++i) {
            res /= i;
        }
        return res;
    }
}
