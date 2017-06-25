package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

public class BerlinClock implements TimeConverter {
    private static final String COLON_SEPARATOR = ":";
    private static final int CAPACITY = 28;
    private final FullSegmentStrategy secondsBuilder;
    private final FullSegmentStrategy minutesBuilder;
    private final FullSegmentStrategy hoursBuilder;

    BerlinClock(FullSegmentStrategy ...builders) {
        this.secondsBuilder = builders[0];           // Seconds Builder Instance
        this.minutesBuilder = builders[1];          // Minutes Builder Instance
        this.hoursBuilder = builders[2];           // Hours Builder Instance
    }

    @Override
    public String convertTime(String aTime) {
        String[] tokens = aTime.split(COLON_SEPARATOR);

        return new StringBuilder(CAPACITY)
                .append(secondsBuilder.buildFullSegment(tokens[2]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(hoursBuilder.buildFullSegment(tokens[0]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(minutesBuilder.buildFullSegment(tokens[1])).toString();
    }
}