package com.ubs.opsit.interviews.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * HourStrategyTest
 *
 * @author Hayk Hovhannisyan
 */
public class HourStrategyTest {
     

    private final UpperSegmentStrategy upperSegmentStrategy = new HourStrategy();
    private final LowerSegmentStrategy lowerSegmentStrategy = new HourStrategy();
    private final FullSegmentStrategy fullSegmentStrategy = new HourStrategy();

    @Test
    public void testBuildUpperSegment() throws Exception {
        assertEquals(upperSegmentStrategy.buildUpperSegment("15"), "RRRO");
    }

    @Test
    public void testBuildWrongUpperSegment() throws Exception {
        assertNotEquals(upperSegmentStrategy.buildUpperSegment("15"), "YYYY");
    }

    @Test
    public void testBuildLowerSegment() throws Exception {
        assertEquals(lowerSegmentStrategy.buildLowerSegment("03"), "RRRO");
    }

    @Test
    public void testBuildWrongLowerSegment() throws Exception {
        assertNotEquals(lowerSegmentStrategy.buildLowerSegment("03"), "YYYO");
    }

    @Test
    public void testBuildFullSegment() throws Exception {
        assertEquals(fullSegmentStrategy.buildFullSegment("17"), "RRRO" + System.lineSeparator() + "RROO");
    }

    @Test
    public void testBuildWrongFullSegment() throws Exception {
        assertNotEquals(fullSegmentStrategy.buildFullSegment("17"), "YYYY" + System.lineSeparator() + "YYYY");
    }
}