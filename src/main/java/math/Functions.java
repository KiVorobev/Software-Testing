package math;

public class Functions {
    private Series s = new Series();

    public double sin(double x) {
        return s.decomposeToSeries(x, s.sinSeries);
    }

    public double cos(double x) {
        return 1 - 2 * Math.pow(sin(x / 2), 2);
    }

    public double tan(double x) {
        return sin(x) / cos(x);
    }

    public double csc(double x) {
        return 1 / sin(x);
    }

    public double ln(double x) {
        if (x <= 0) {
            return Double.NaN;
        }
        return s.decomposeToSeries(x, s.lnSeries);
    }

    public double log3(double x) {
        return ln(x) / ln(3);
    }

    public double log5(double x) {
        return ln(x) / ln(5);
    }

    public double log10(double x) {
        return ln(x) / ln(10);
    }

    public void setS(Series s) {
        this.s = s;
    }
}
