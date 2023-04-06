import math.Functions;
import math.Series;

import static math.Functions.*;

public class Task {
    private final Functions f = new Functions();

    public double trigonometricFunction(double x) {
        return Math.pow(Math.pow(f.csc(x), 2) - f.cos(x) + (f.sin(x) * f.tan(x)) + Math.pow(f.sin(x), 3) + f.csc(x), 2);
    }

    public double logarithmicFunction(double x) {
        return ((((f.log5(x) - f.ln(x)) / f.log5(x)) / f.log3(x)) * f.log5(x)) * (f.log3(x) + f.log10(x));
    }

    public double function(double x) {
        if (x <= 0)
            return trigonometricFunction(x);
        else
            return logarithmicFunction(x);
    }
}
