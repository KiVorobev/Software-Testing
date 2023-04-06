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
}
