package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriesUnitTest {

    Series s;
    double ACCURACY = 0.0001;

    @BeforeEach
    void init() {
        s = Mockito.spy(new Series());
    }

    @Test
    void decomposeToSinSeriesTest() {
        assertEquals(0., s.decomposeToSeries(0, s.sinSeries), ACCURACY);
        assertEquals(0., s.decomposeToSeries(Math.PI, s.sinSeries), ACCURACY);
        assertEquals(1., s.decomposeToSeries(Math.PI / 2, s.sinSeries), ACCURACY);
        assertEquals(-1., s.decomposeToSeries(3 * Math.PI / 2, s.sinSeries), ACCURACY);
        assertEquals(0.7071, s.decomposeToSeries(Math.PI / 4, s.sinSeries), ACCURACY);
        assertEquals(-0.7071, s.decomposeToSeries(5 * Math.PI / 4, s.sinSeries), ACCURACY);
    }

    @Test
    void decomposeToLnSeriesTest() {
        assertEquals(0, s.decomposeToSeries(1., s.lnSeries), ACCURACY);
        assertEquals(0.6931, s.decomposeToSeries(2, s.lnSeries), ACCURACY);
        assertEquals(1.0986, s.decomposeToSeries(3, s.lnSeries), ACCURACY);
        assertEquals(1.3862, s.decomposeToSeries(4, s.lnSeries), ACCURACY);
        assertEquals(1, s.decomposeToSeries(Math.exp(1), s.lnSeries), ACCURACY);
        assertEquals(2, s.decomposeToSeries(Math.exp(2), s.lnSeries), ACCURACY);
        assertEquals(3, s.decomposeToSeries(Math.exp(3), s.lnSeries), ACCURACY);
        assertEquals(4, s.decomposeToSeries(Math.exp(4), s.lnSeries), ACCURACY);
    }
}