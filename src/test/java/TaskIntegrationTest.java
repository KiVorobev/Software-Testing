import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskIntegrationTest {
    static Task t;

    @BeforeAll
    static void init() {
        t = new Task();
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