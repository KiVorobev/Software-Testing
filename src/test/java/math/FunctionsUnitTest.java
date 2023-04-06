package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsUnitTest {
    Functions f;
    Series s;

    @BeforeEach
    void init() {
        f = Mockito.spy(new Functions());
        s = Mockito.spy(new Series());
    }

    @Test
    void sinTest() {
        Mockito.when(s.decomposeToSeries(0, s.sinSeries)).thenReturn(0.);
        Mockito.when(s.decomposeToSeries(Math.PI / 2, s.sinSeries)).thenReturn(1.);
        f.setS(s);

        assertEquals(0., f.sin(0));
        assertEquals(1., f.sin(Math.PI / 2));
    }

    @Test
    void cosTest() {
        Mockito.when(f.sin(0)).thenReturn(0.);
        Mockito.when(f.sin(Math.PI / 4)).thenReturn(0.7071);
        Mockito.when(f.sin(Math.PI / 2)).thenReturn(1.);
        Mockito.when(f.sin(3 * Math.PI / 4)).thenReturn(0.7071);

        assertEquals(1., f.cos(0), 0.0001);
        assertEquals(0., f.cos(Math.PI / 2), 0.0001);
        assertEquals(-1., f.cos(Math.PI), 0.0001);
        assertEquals(0., f.cos(3 * Math.PI / 2), 0.0001);
    }

    @Test
    void tanTest() {
        Mockito.when(f.sin(Math.PI / 4)).thenReturn(0.7071);
        Mockito.when(f.cos(Math.PI / 4)).thenReturn(0.7071);
        assertEquals(1., f.tan(Math.PI / 4), 0.001);
    }

    @Test
    void log3Test() {
        Mockito.when(f.ln(3.)).thenReturn(1.0986);
        Mockito.when(f.ln(9.)).thenReturn(2.1972);
        Mockito.when(f.ln(1./3.)).thenReturn(-1.0986);

        assertEquals(1., f.log3(3.));
        assertEquals(2., f.log3(9.), 0.001);
        assertEquals(-1., f.log3(1./3.), 0.001);
    }

    @Test
    void log5Test() {
        Mockito.when(f.ln(5.)).thenReturn(1.609);
        Mockito.when(f.ln(25.)).thenReturn(3.2189);
        Mockito.when(f.ln(1./5.)).thenReturn(-1.6094);

        assertEquals(1., f.log5(5.));
        assertEquals(2., f.log5(25.), 0.001);
        assertEquals(-1., f.log5(1./5.), 0.001);
    }

    @Test
    void log10Test() {
        Mockito.when(f.ln(10.)).thenReturn(2.303);
        Mockito.when(f.ln(100.)).thenReturn(4.605);
        Mockito.when(f.ln(1./1000.)).thenReturn(-6.908);

        assertEquals(1., f.log10(10.));
        assertEquals(2., f.log10(100.), 0.001);
        assertEquals(-3., f.log10(1./1000.), 0.001);
    }
}
