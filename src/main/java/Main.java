import math.Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.function.Function;

public class Main {
    private static final double min = -4;
    private static final double max = 4;
    private static final double step = 0.05;

    static void printCsv(Function<Double, Double> function, double min, double max, double step, String fileName) throws IOException {
        File file = new File("src/main/resources/" + fileName);
        file.delete();
        file.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("x,value\n");
            for (double x = min; x <= max; x += step) {
                bufferedWriter.write(String.format(Locale.US, "%.2f", x) + "," + function.apply(x) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Functions f = new Functions();
        Task t = new Task();
        printCsv(f::cos, min, max, step, "cos.csv");
        printCsv(f::sin, min, max, step, "sin.csv");
        printCsv(f::tan, min, max, step, "tan.csv");
        printCsv(f::csc, min, max, step, "csc.csv");
        printCsv(f::log3, min, max, step, "log3.csv");
        printCsv(f::log5, min, max, step, "log5.csv");
        printCsv(f::log10, min, max, step, "log10.csv");
        printCsv(t::trigonometricFunction, min, max, step, "trigonometric");
        printCsv(t::logarithmicFunction, min, max, step, "logarithmic");
        printCsv(t::function, min, max, step, "function");
    }
}