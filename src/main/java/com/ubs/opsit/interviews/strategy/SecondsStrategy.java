package com.ubs.opsit.interviews.strategy;

import static com.ubs.opsit.interviews.utils.NUMBERS.ZERO;
import static com.ubs.opsit.interviews.utils.NUMBERS.TWO;

/**
 * FullSegmentStrategy
 *
 * @author Hayk Hovhannisyan
 */
public class SecondsStrategy implements FullSegmentStrategy {

    @Override
    public String buildFullSegment(String value) {
        int seconds = Integer.valueOf(value);
        return Math.floorMod(seconds, TWO.value()) == ZERO.value() ? "Y" : "O";
    }
}