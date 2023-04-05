import static math.Functions.*;

public class Task {
    public double trigonometricFunction(double x) {
        return Math.pow(Math.pow(csc(x), 2) - cos(x) + (sin(x) * tan(x)) + Math.pow(sin(x), 3) + csc(x), 2);
    }

    public double logarithmicFunction(double x) {
        return ((((log5(x) - ln(x)) / log5(x)) / log3(x)) * log5(x)) * (log3(x) + log10(x));
    }

    public double function(double x) {
        if (x <= 0)
            return trigonometricFunction(x);
        else
            return logarithmicFunction(x);
    }
}
