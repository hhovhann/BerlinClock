package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

/**
 * SecondsBuilder
 *
 * @author Hayk Hovhannisyan
 */
public class SecondsBuilder implements FullSegmentStrategy {

    @Override
    public String buildFullSegment(String value) {
        int seconds = Integer.valueOf(value);
        return Math.floorMod(seconds, 2) == 0 ? "Y" : "O";
    }
}