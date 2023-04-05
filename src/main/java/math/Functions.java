package math;

public class Functions {
    private final Decomposable sinSeries = (x, n) -> (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / Series.getFactorial(2 * n + 1);
    private final Decomposable lnSeries = (x, n) -> (Math.pow(-1, n - 1) * Math.pow(x, n) / n);
}
