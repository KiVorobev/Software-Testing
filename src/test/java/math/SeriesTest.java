package math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static math.Functions.sin;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriesTest {
    @Test
    void sinTest() {
        assertEquals(1, sin(Math.PI / 2));
    }
}