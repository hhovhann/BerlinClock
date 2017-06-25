package com.ubs.opsit.interviews.builder;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;
import com.ubs.opsit.interviews.strategy.LowerSegmentStrategy;
import com.ubs.opsit.interviews.strategy.UpperSegmentStrategy;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

/**
 * MinutesBuilder
 *
 * @author Hayk Hovhannisyan
 */
public class MinutesBuilder implements UpperSegmentStrategy, LowerSegmentStrategy, FullSegmentStrategy {
    @Override
    public String buildUpperSegment(String value) {
        String result = "";
        int lowerMinute = Integer.valueOf(value);
        if (Math.floorDiv(lowerMinute, 5) == 0) {
            result = "OOOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 1) {
            result = "YOOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 2) {
            result = "YYOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 3) {
            result = "YYROOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 4) {
            result = "YYRYOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 5) {
            result = "YYRYYOOOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 6) {
            result = "YYRYYROOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 7) {
            result = "YYRYYRYOOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 8) {
            result = "YYRYYRYYOOO";
        } else if (Math.floorDiv(lowerMinute, 5) == 9) {
            result = "YYRYYRYYROO";
        } else if (Math.floorDiv(lowerMinute, 5) == 10) {
            result = "YYRYYRYYRYO";
        } else if (Math.floorDiv(lowerMinute, 5) == 11) {
            result = "YYRYYRYYRYY";
        }
        return result;
    }

    @Override
    public String buildLowerSegment(String value) {
        String result = "";
        int lowerMinute = Integer.valueOf(value);
        if (Math.floorDiv(lowerMinute, 1) == 0)
            result = "OOOO";
        else if (Math.floorDiv(lowerMinute, 1) == 1)
            result = "YOOO";
        else if (Math.floorDiv(lowerMinute, 1) == 2)
            result = "YYOO";
        else if (Math.floorDiv(lowerMinute, 1) == 3)
            result = "YYYO";
        else if (Math.floorDiv(lowerMinute, 1) == 4)
            result = "YYYY";

        return result;
    }

    @Override
    public String buildFullSegment(String value) {
        int fullHour = Integer.valueOf(value);
        int residue = Math.floorMod(fullHour, 5);

        return buildUpperSegment(String.valueOf(fullHour - residue)) + LINE_SEPARATOR + buildLowerSegment(String.valueOf(residue));
    }
}