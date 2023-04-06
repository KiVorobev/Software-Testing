import math.Functions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TaskUnitTest {
    static Task t;
    static Functions f;

    @BeforeAll
    static void init() {
        t = Mockito.spy(new Task());
        f = Mockito.spy(new Functions());
    }

    @Test
    void trigonometricFunctionTest() {
        Mockito.when(f.sin(-Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2.);
        Mockito.when(f.cos(-Math.PI / 4)).thenReturn(Math.sqrt(2) / 2.);
        Mockito.when(f.tan(-Math.PI / 4)).thenReturn(-1.);
        Mockito.when(f.csc(-Math.PI / 4)).thenReturn(-Math.sqrt(2));

        Mockito.when(f.sin(-Math.PI / 3)).thenReturn(-Math.sqrt(3) / 2.);
        Mockito.when(f.cos(-Math.PI / 3)).thenReturn(0.5);
        Mockito.when(f.tan(-Math.PI / 3)).thenReturn(-Math.sqrt(3));
        Mockito.when(f.csc(-Math.PI / 3)).thenReturn(-2. / Math.sqrt(3));

        Mockito.when(f.sin(0.)).thenReturn(0.);
        Mockito.when(f.cos(0.)).thenReturn(1.);
        Mockito.when(f.tan(0.)).thenReturn(0.);
        Mockito.when(f.csc(0)).thenReturn(Double.NaN);
        t.setF(f);

        assertEquals(0.0539, t.trigonometricFunction(-Math.PI / 4), 0.0001);
        assertEquals(0.2799, t.trigonometricFunction(-Math.PI / 3), 0.0001);
        assertEquals(Double.NaN, t.trigonometricFunction(0));
    }

    @Test
    void logarithmicFunctionTest() {
        Mockito.when(f.log3(3)).thenReturn(1.);
        Mockito.when(f.log5(3)).thenReturn(0.6826);
        Mockito.when(f.log10(3)).thenReturn(0.4771);
        Mockito.when(f.ln(3)).thenReturn(1.0986);

        Mockito.when(f.log3(9)).thenReturn(2.);
        Mockito.when(f.log5(9)).thenReturn(1.3652);
        Mockito.when(f.log10(9)).thenReturn(0.9542);
        Mockito.when(f.ln(9)).thenReturn(2.1972);

        Mockito.when(f.log3(31)).thenReturn(3.1257);
        Mockito.when(f.log5(31)).thenReturn(2.1336);
        Mockito.when(f.log10(31)).thenReturn(1.4913);
        Mockito.when(f.ln(31)).thenReturn(3.4339);
        t.setF(f);

        assertEquals(-0.614, t.logarithmicFunction(3), 0.001);
        assertEquals(-1.229, t.logarithmicFunction(9), 0.001);
        assertEquals(-1.92, t.logarithmicFunction(31), 0.001);
    }

    @Test
    void functionTest() {
        Mockito.when(t.logarithmicFunction(0.0001)).thenReturn(5.151);
        Mockito.when(t.logarithmicFunction(2591.3235)).thenReturn(-4.396);

        assertEquals(5.151, t.logarithmicFunction(0.0001));
        assertEquals(-4.396, t.logarithmicFunction(2591.3235));
    }
}