package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;
import com.ubs.opsit.interviews.strategy.LowerSegmentStrategy;
import com.ubs.opsit.interviews.strategy.UpperSegmentStrategy;
import org.junit.Test;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * MinutesBuilderTest
 *
 * @author Hayk Hovhannisyan
 */
public class MinutesBuilderTest {

    private final UpperSegmentStrategy upperSegmentStrategy = new MinutesBuilder();
    private final LowerSegmentStrategy lowerSegmentStrategy = new MinutesBuilder();
    private final FullSegmentStrategy minuteFullStrategy = new MinutesBuilder();

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
        assertEquals(minuteFullStrategy.buildFullSegment("59"), "YYRYYRYYRYY" + LINE_SEPARATOR + "YYYY");
    }

    @Test
    public void testBuildWrongSegment() throws Exception {
        assertNotEquals(minuteFullStrategy.buildFullSegment("59"), "YYYYYYYYYYY" + LINE_SEPARATOR + "YYYY");
    }
}