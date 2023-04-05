package math;

public class Series {

    public double decomposeToSeries(double x, int n, Decomposable d) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d.calculateStep(x, i);
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
