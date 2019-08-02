package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * SecondsStrategyTest
 *
 * @author Hayk Hovhannisyan
 */
public class SecondsStrategyTest {

    private final FullSegmentStrategy fullSegmentStrategy = new SecondsBuilder();

    @Test
    public void testBuildSeconds() throws Exception {
        assertEquals(fullSegmentStrategy.buildFullSegment("59"), "O");
    }

    @Test
    public void testBuildWrongSeconds() throws Exception {
        assertNotEquals(fullSegmentStrategy.buildFullSegment("59"), "Y");
    }
}