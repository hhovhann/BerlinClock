package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.strategy.FullSegmentStrategy;

public class BerlinClock implements TimeConverter {
    private static final String COLON_SEPARATOR = ":";
    private static final int CAPACITY = 28;
    private final FullSegmentStrategy secondsBuildingStrategy;
    private final FullSegmentStrategy minuteBuildingStrategy;
    private final FullSegmentStrategy hourBuildingStrategy;

    BerlinClock(FullSegmentStrategy secondsBuildingStrategy, FullSegmentStrategy minuteBuildingStrategy, FullSegmentStrategy hourBuildingStrategy) {
        this.secondsBuildingStrategy = secondsBuildingStrategy;
        this.minuteBuildingStrategy = minuteBuildingStrategy;
        this.hourBuildingStrategy = hourBuildingStrategy;
    }

    @Override
    public String convertTime(String aTime) {
        String[] tokens = aTime.split(COLON_SEPARATOR);

        return new StringBuilder(CAPACITY)
                .append(secondsBuildingStrategy.buildFullSegment(tokens[2]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(hourBuildingStrategy.buildFullSegment(tokens[0]))
                .append(FullSegmentStrategy.LINE_SEPARATOR)
                .append(minuteBuildingStrategy.buildFullSegment(tokens[1])).toString();
    }
}