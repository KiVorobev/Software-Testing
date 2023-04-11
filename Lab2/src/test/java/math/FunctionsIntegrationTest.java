package math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsIntegrationTest {
    static Functions f;

    @BeforeAll
    static void init() {
        f = new Functions();
    }

    @Test
    void sinTest() {
        assertEquals(0., f.sin(0.), 0.0001);
        assertEquals(1., f.sin(Math.PI / 2), 0.0001);
        assertEquals(0., f.sin(Math.PI), 0.0001);
        assertEquals(-1., f.sin(3 * Math.PI / 2), 0.0001);
        assertEquals(0.7071, f.sin(Math.PI / 4), 0.0001);
        assertEquals(-0.7071, f.sin(5 * Math.PI / 4), 0.0001);
    }

    @Test
    void cosTest() {
        assertEquals(1., f.cos(0), 0.0001);
        assertEquals(0., f.cos(Math.PI / 2), 0.0001);
        assertEquals(-1., f.cos(Math.PI), 0.0001);
        assertEquals(0., f.cos(3 * Math.PI / 2), 0.0001);
    }

    @Test
    void tanTest() {
        assertEquals(1., f.tan(Math.PI / 4), 0.001);
    }

    @Test
    void log3Test() {
        assertEquals(1., f.log3(3.));
        assertEquals(2., f.log3(9.), 0.001);
        assertEquals(-1., f.log3(1./3.), 0.001);
    }

    @Test
    void log5Test() {
        assertEquals(1., f.log5(5.));
        assertEquals(2., f.log5(25.), 0.001);
        assertEquals(-1., f.log5(1./5.), 0.001);
    }

    @Test
    void log10Test() {
        assertEquals(1., f.log10(10.));
        assertEquals(2., f.log10(100.), 0.001);
        assertEquals(-3., f.log10(1./1000.), 0.001);
    }

    @Test
    void lnTest() {
        assertEquals(0., f.ln(1.), 0.0001);
        assertEquals(0.6931, f.ln(2.), 0.0001);
        assertEquals(1.0986, f.ln(3.), 0.0001);
        assertEquals(1.3862, f.ln(4.), 0.0001);
        assertEquals(1., f.ln(Math.exp(1.)), 0.0001);
        assertEquals(2., f.ln(Math.exp(2.)), 0.0001);
        assertEquals(3., f.ln(Math.exp(3.)), 0.0001);
        assertEquals(4., f.ln(Math.exp(4.)), 0.0001);
    }

    @Test
    void cscTest() {
        assertEquals(-1.4142, f.csc(- Math.PI / 4), 0.0001);
        assertEquals(-1., f.csc(- Math.PI / 2), 0.0001);
        assertEquals(1., f.csc(Math.PI / 2), 0.0001);
        assertEquals(1.4142, f.csc(Math.PI / 4), 0.0001);
    }
}
