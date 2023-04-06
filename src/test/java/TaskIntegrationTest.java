import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TaskIntegrationTest {
    static Task t;

    @BeforeAll
    static void init() {
        t = new Task();
    }

    @Test
    void trigonometricFunctionTest() {
        assertEquals(0.0539, t.trigonometricFunction(-Math.PI / 4), 0.0001);
        assertEquals(0.2799, t.trigonometricFunction(-Math.PI / 3), 0.0001);
        assertEquals(Double.POSITIVE_INFINITY, t.trigonometricFunction(0));
    }

    @Test
    void logarithmicFunctionTest() {
        assertEquals(-0.614, t.logarithmicFunction(3), 0.001);
        assertEquals(-1.229, t.logarithmicFunction(9), 0.001);
        assertEquals(-1.92, t.logarithmicFunction(31), 0.001);
    }

    @Test
    void functionTest() {
        assertEquals(5.151, t.logarithmicFunction(0.0001), 0.001);
        assertEquals(-4.396, t.logarithmicFunction(2591.3235), 0.001);
    }
}