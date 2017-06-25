package com.ubs.opsit.interviews.strategy;

/**
 * FullSegmentStrategy
 *
 * @author Hayk Hovhannisyan
 */
public interface FullSegmentStrategy {
    String LINE_SEPARATOR = System.getProperty("line.separator");

    String buildFullSegment(String value);
}