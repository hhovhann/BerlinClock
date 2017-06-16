package com.ubs.opsit.interviews.strategy;

/**
 * TimeBuildingStrategy
 *
 * @author Hayk Hovhannisyan
 */
public interface TimeBuildingStrategy {
    String LINE_SEPARATOR = System.getProperty("line.separator");

    String buildUpperSegment(String value);

    String buildLowerSegment(String value);

    String buildFullSegment(String value);
}