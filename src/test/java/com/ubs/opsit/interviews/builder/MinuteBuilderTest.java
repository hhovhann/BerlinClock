package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;
import com.ubs.opsit.interviews.strategy.LowerSegmentStrategy;
import com.ubs.opsit.interviews.strategy.UpperSegmentStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * MinuteBuilderTest
 *
 * @author Hayk Hovhannisyan
 */
public class MinuteBuilderTest {

    private final UpperSegmentStrategy upperSegmentStrategy = new MinuteBuilder();
    private final LowerSegmentStrategy lowerSegmentStrategy = new MinuteBuilder();
    private final FullSegmentStrategy minuteFullStrategy = new MinuteBuilder();

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