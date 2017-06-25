package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;
import com.ubs.opsit.interviews.strategy.LowerSegmentStrategy;
import com.ubs.opsit.interviews.strategy.UpperSegmentStrategy;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

/**
 * HoursBuilder
 *
 * @author Hayk Hovhannisyan
 */
public class HoursBuilder implements UpperSegmentStrategy, LowerSegmentStrategy, FullSegmentStrategy {

    @Override
    public String buildUpperSegment(String value) {
        String result = "";
        int first_segment = Integer.valueOf(value);
        if (Math.floorDiv(first_segment, 5) == 0)
            result = "OOOO";
        else if (Math.floorDiv(first_segment, 5) == 1)
            result = "ROOO";
        else if (Math.floorDiv(first_segment, 5) == 2)
            result = "RROO";
        else if (Math.floorDiv(first_segment, 5) == 3)
            result = "RRRO";
        else if (Math.floorDiv(first_segment, 5) == 4)
            result = "RRRR";

        return result;
    }

    @Override
    public String buildLowerSegment(String value) {
        String result = "";
        int lowerHour = Integer.valueOf(value);
        if (Math.floorDiv(lowerHour, 1) == 0)
            result = "OOOO";
        else if (Math.floorDiv(lowerHour, 1) == 1)
            result = "ROOO";
        else if (Math.floorDiv(lowerHour, 1) == 2)
            result = "RROO";
        else if (Math.floorDiv(lowerHour, 1) == 3)
            result = "RRRO";
        else if (Math.floorDiv(lowerHour, 1) == 4)
            result = "RRRR";

        return result;
    }

    @Override
    public String buildFullSegment(String value) {
        int fullHour = Integer.valueOf(value);
        int residue = Math.floorMod(fullHour, 5);

        return buildUpperSegment(String.valueOf(fullHour - residue)) + LINE_SEPARATOR + buildLowerSegment(String.valueOf(residue));
    }
}