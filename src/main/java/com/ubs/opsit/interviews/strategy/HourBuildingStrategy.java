package com.ubs.opsit.interviews.strategy;

import static com.ubs.opsit.interviews.utils.NUMBERS.*;

/**
 * TimeBuildingStrategy
 *
 * @author Hayk Hovhannisyan
 */
public class HourBuildingStrategy implements TimeBuildingStrategy {

    @Override
    public String buildUpperSegment(String value) {
        String result = "";
        int first_segment = Integer.valueOf(value);
        if (Math.floorDiv(first_segment, FIVE.value()) == ZERO.value())
            result = "OOOO";
        else if (Math.floorDiv(first_segment, FIVE.value()) == ONE.value())
            result = "ROOO";
        else if (Math.floorDiv(first_segment, FIVE.value()) == TWO.value())
            result = "RROO";
        else if (Math.floorDiv(first_segment, FIVE.value()) == THREE.value())
            result = "RRRO";
        else if (Math.floorDiv(first_segment, FIVE.value()) == FOUR.value())
            result = "RRRR";

        return result;
    }

    @Override
    public String buildLowerSegment(String value) {
        String result = "";
        int lowerHour = Integer.valueOf(value);
        if (Math.floorDiv(lowerHour, ONE.value()) == ZERO.value())
            result = "OOOO";
        else if (Math.floorDiv(lowerHour, ONE.value()) == ONE.value())
            result = "ROOO";
        else if (Math.floorDiv(lowerHour, ONE.value()) == TWO.value())
            result = "RROO";
        else if (Math.floorDiv(lowerHour, ONE.value()) == THREE.value())
            result = "RRRO";
        else if (Math.floorDiv(lowerHour, ONE.value()) == FOUR.value())
            result = "RRRR";

        return result;
    }

    @Override
    public String buildFullSegment(String value) {
        int fullHour = Integer.valueOf(value);
        int residue = Math.floorMod(fullHour, FIVE.value());

        return buildUpperSegment(String.valueOf(fullHour - residue)) + LINE_SEPARATOR + buildLowerSegment(String.valueOf(residue));
    }
}