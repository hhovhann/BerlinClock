package com.ubs.opsit.interviews.strategy;

import static com.ubs.opsit.interviews.utils.NUMBERS.*;

/**
 * FullSegmentStrategy
 *
 * @author Hayk Hovhannisyan
 */
public class MinuteStrategy implements UpperSegmentStrategy, LowerSegmentStrategy, FullSegmentStrategy {
    @Override
    public String buildUpperSegment(String value) {
        String result = "";
        int lowerMinute = Integer.valueOf(value);
        if (Math.floorDiv(lowerMinute, FIVE.value()) == ZERO.value()) {
            result = "OOOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == ONE.value()) {
            result = "YOOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == TWO.value()) {
            result = "YYOOOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == THREE.value()) {
            result = "YYROOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == FOUR.value()) {
            result = "YYRYOOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == FIVE.value()) {
            result = "YYRYYOOOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == SIX.value()) {
            result = "YYRYYROOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == SEVEN.value()) {
            result = "YYRYYRYOOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == EIGHT.value()) {
            result = "YYRYYRYYOOO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == NINE.value()) {
            result = "YYRYYRYYROO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == TEN.value()) {
            result = "YYRYYRYYRYO";
        } else if (Math.floorDiv(lowerMinute, FIVE.value()) == ELEVEN.value()) {
            result = "YYRYYRYYRYY";
        }
        return result;
    }

    @Override
    public String buildLowerSegment(String value) {
        String result = "";
        int lowerMinute = Integer.valueOf(value);
        if (Math.floorDiv(lowerMinute, ONE.value()) == ZERO.value())
            result = "OOOO";
        else if (Math.floorDiv(lowerMinute, ONE.value()) == ONE.value())
            result = "YOOO";
        else if (Math.floorDiv(lowerMinute, ONE.value()) == TWO.value())
            result = "YYOO";
        else if (Math.floorDiv(lowerMinute, ONE.value()) == THREE.value())
            result = "YYYO";
        else if (Math.floorDiv(lowerMinute, ONE.value()) == FOUR.value())
            result = "YYYY";

        return result;
    }

    @Override
    public String buildFullSegment(String value) {
        int fullHour = Integer.valueOf(value);
        int residue = Math.floorMod(fullHour, FIVE.value());

        return buildUpperSegment(String.valueOf(fullHour - residue)) + LINE_SEPARATOR + buildLowerSegment(String.valueOf(residue));
    }
}