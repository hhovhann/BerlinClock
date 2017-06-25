package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

public class BerlinClock implements TimeConverter {
    private static final String COLON_SEPARATOR = ":";
    private static final int CAPACITY = 28;
    private final FullSegmentStrategy secondsBuilder;
    private final FullSegmentStrategy minuteBuilder;
    private final FullSegmentStrategy hourBuilder;

    BerlinClock(FullSegmentStrategy ...builders) {
        this.secondsBuilder = builders[0];          // Seconds Builder Instance
        this.minuteBuilder = builders[1];          // Minutes Builder Instance
        this.hourBuilder = builders[2];           // Hours Builder Instance
    }

    @Override
    public String convertTime(String aTime) {
        String[] tokens = aTime.split(COLON_SEPARATOR);

        return new StringBuilder(CAPACITY)
                .append(secondsBuilder.buildFullSegment(tokens[2]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(hourBuilder.buildFullSegment(tokens[0]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(minuteBuilder.buildFullSegment(tokens[1])).toString();
    }
}