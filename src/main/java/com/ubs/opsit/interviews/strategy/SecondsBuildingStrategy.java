package com.ubs.opsit.interviews.strategy;

import static com.ubs.opsit.interviews.utils.NUMBERS.ZERO;
import static com.ubs.opsit.interviews.utils.NUMBERS.TWO;

/**
 * TimeBuildingStrategy
 *
 * @author Hayk Hovhannisyan
 */
public class SecondsBuildingStrategy implements TimeBuildingStrategy {

    @Override
    public String buildUpperSegment(String value) {
        return null;
    }

    @Override
    public String buildLowerSegment(String value) {
        return null;
    }
    
    @Override
    public String buildFullSegment(String value) {
        int seconds = Integer.valueOf(value);
        return Math.floorMod(seconds, TWO.value()) == ZERO.value() ? "Y" : "O";
    }
}