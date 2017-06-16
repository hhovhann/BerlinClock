package com.ubs.opsit.interviews.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * TimeBuildingStrategyTest
 *
 * @author Hayk Hovhannisyan
 */
public class TimeBuildingStrategyTest {
    private final TimeBuildingStrategy secondBuildingStrategy = new SecondsBuildingStrategy();
    private final TimeBuildingStrategy minuteBuildingStrategy = new MinuteBuildingStrategy();
    private final TimeBuildingStrategy hourBuildingStrategy = new HourBuildingStrategy();

    @Test
    public void testBuildSeconds() throws Exception {
        assertEquals(secondBuildingStrategy.buildFullSegment("59"), "O");
    }

    @Test
    public void testBuildWrongSeconds() throws Exception {
        assertNotEquals(secondBuildingStrategy.buildFullSegment("59"), "Y");
    }

    @Test
    public void testBuildUpperHourSegment() throws Exception {
        assertEquals(hourBuildingStrategy.buildUpperSegment("15"), "RRRO");
    }

    @Test
    public void testBuildWrongUpperHourSegment() throws Exception {
        assertNotEquals(hourBuildingStrategy.buildUpperSegment("15"), "YYYY");
    }

    @Test
    public void testBuildLowerHourSegment() throws Exception {
        assertEquals(hourBuildingStrategy.buildLowerSegment("03"), "RRRO");
    }

    @Test
    public void testBuildWrongLowerHourSegment() throws Exception {
        assertNotEquals(hourBuildingStrategy.buildLowerSegment("03"), "YYYO");
    }

    @Test
    public void testBuildFullSegment() throws Exception {
        assertEquals(hourBuildingStrategy.buildFullSegment("17"), "RRRO" + System.lineSeparator() + "RROO");
    }

    @Test
    public void testBuildWrongFullSegment() throws Exception {
        assertNotEquals(hourBuildingStrategy.buildFullSegment("17"), "YYYY" + System.lineSeparator() + "YYYY");
    }

    @Test
    public void testBuildUpperMinuteSegment() throws Exception {
        assertEquals(minuteBuildingStrategy.buildUpperSegment("45"), "YYRYYRYYROO");
    }

    @Test
    public void testBuildWrongUpperMinuteSegment() throws Exception {
        assertNotEquals(minuteBuildingStrategy.buildUpperSegment("45"), "YOYOOYYOYYO");
    }

    @Test
    public void testBuildLowerMinuteSegment() throws Exception {
        assertEquals(minuteBuildingStrategy.buildLowerSegment("00"), "OOOO");
    }

    @Test
    public void testBuildWrongLowerMinuteSegment() throws Exception {
        assertNotEquals(minuteBuildingStrategy.buildLowerSegment("00"), "RRRR");
    }

    @Test
    public void testBuildMinuteSegment() throws Exception {
        assertEquals(minuteBuildingStrategy.buildFullSegment("59"), "YYRYYRYYRYY" + System.lineSeparator() + "YYYY");
    }

    @Test
    public void testBuildWrongMinuteSegment() throws Exception {
        assertNotEquals(minuteBuildingStrategy.buildFullSegment("59"), "YYYYYYYYYYY" + System.lineSeparator() + "YYYY");
    }
}