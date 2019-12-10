package utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherUtilsTest {

    @Test
    public void getDayOfWeek() {
        WeatherUtils weatherUtils = new WeatherUtils();
        String dayOfWeek = weatherUtils.getDayOfWeek(1, "yyyy-MM-dd");
        assertEquals("It is the same?", "2019-11-26", dayOfWeek);
    }
}