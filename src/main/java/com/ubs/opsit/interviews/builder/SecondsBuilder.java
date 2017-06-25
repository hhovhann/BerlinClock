package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

import static com.ubs.opsit.interviews.utils.NUMBERS.ZERO;
import static com.ubs.opsit.interviews.utils.NUMBERS.TWO;

/**
 * SecondsBuilder
 *
 * @author Hayk Hovhannisyan
 */
public class SecondsBuilder implements FullSegmentStrategy {

    @Override
    public String buildFullSegment(String value) {
        int seconds = Integer.valueOf(value);
        return Math.floorMod(seconds, TWO.value()) == ZERO.value() ? "Y" : "O";
    }
}