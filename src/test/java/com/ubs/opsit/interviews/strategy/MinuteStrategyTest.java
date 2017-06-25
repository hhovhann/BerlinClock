package com.ubs.opsit.interviews.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * MinuteStrategyTest
 *
 * @author Hayk Hovhannisyan
 */
public class MinuteStrategyTest {

    private final UpperSegmentStrategy upperSegmentStrategy = new MinuteStrategy();
    private final LowerSegmentStrategy lowerSegmentStrategy = new MinuteStrategy();
    private final FullSegmentStrategy minuteFullStrategy = new MinuteStrategy();

    @Test
    public void testBuildUpperSegment() throws Exception {
        assertEquals(upperSegmentStrategy.buildUpperSegment("45"), "YYRYYRYYROO");
    }

    @Test
    public void testBuildWrongUpperSegment() throws Exception {
        assertNotEquals(upperSegmentStrategy.buildUpperSegment("45"), "YOYOOYYOYYO");
    }

    @Test
    public void testBuildLowerSegment() throws Exception {
        assertEquals(lowerSegmentStrategy.buildLowerSegment("00"), "OOOO");
    }

    @Test
    public void testBuildWrongLowerSegment() throws Exception {
        assertNotEquals(lowerSegmentStrategy.buildLowerSegment("00"), "RRRR");
    }

    @Test
    public void testBuildSegment() throws Exception {
        assertEquals(minuteFullStrategy.buildFullSegment("59"), "YYRYYRYYRYY" + System.lineSeparator() + "YYYY");
    }

    @Test
    public void testBuildWrongSegment() throws Exception {
        assertNotEquals(minuteFullStrategy.buildFullSegment("59"), "YYYYYYYYYYY" + System.lineSeparator() + "YYYY");
    }
}