package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

public class BerlinClock implements TimeConverter {
    private static final String COLON_SEPARATOR = ":";
    private final FullSegmentStrategy secondsBuilder;
    private final FullSegmentStrategy minutesBuilder;
    private final FullSegmentStrategy hoursBuilder;

    BerlinClock(FullSegmentStrategy... builders) {
        this.secondsBuilder = builders[0];           // Seconds Builder Instance
        this.minutesBuilder = builders[1];          // Minutes Builder Instance
        this.hoursBuilder = builders[2];           // Hours Builder Instance
    }

    @Override
    public String convertTime(String aTime) {
        String[] tokens = aTime.split(COLON_SEPARATOR);

        return String.join(LINE_SEPARATOR,
                secondsBuilder.buildFullSegment(tokens[2]),
                hoursBuilder.buildFullSegment(tokens[0]),
                minutesBuilder.buildFullSegment(tokens[1]));
    }
}