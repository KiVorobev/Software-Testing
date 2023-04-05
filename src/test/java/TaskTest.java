import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    static Task task;

    @BeforeAll
    static void setUp() {
        task = new Task();
    }

    @Test
    void trigonometricFunctionTest() {
        assertEquals(4.49822, task.trigonometricFunction(5));
    }

}