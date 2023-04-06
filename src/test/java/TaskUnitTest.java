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
        assertEquals(4.49822, t.trigonometricFunction(5));
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


        assertEquals(-0.614, t.logarithmicFunction(3), 0.001);
        assertEquals(-1.229, t.logarithmicFunction(9), 0.001);
        assertEquals(-1.92, t.logarithmicFunction(31), 0.001);
    }
}