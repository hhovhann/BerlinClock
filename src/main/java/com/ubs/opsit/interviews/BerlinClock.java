package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.strategy.TimeBuildingStrategy;

public class BerlinClock implements TimeConverter {
    private static final String COLON_SEPARATOR = ":";
    private static final int CAPACITY = 28;
    private final TimeBuildingStrategy secondsBuildingStrategy;
    private final TimeBuildingStrategy minuteBuildingStrategy;
    private final TimeBuildingStrategy hourBuildingStrategy;

    BerlinClock(TimeBuildingStrategy secondsBuildingStrategy, TimeBuildingStrategy minuteBuildingStrategy, TimeBuildingStrategy hourBuildingStrategy) {
        this.secondsBuildingStrategy = secondsBuildingStrategy;
        this.minuteBuildingStrategy = minuteBuildingStrategy;
        this.hourBuildingStrategy = hourBuildingStrategy;
    }

    @Override
    public String convertTime(String aTime) {
        String[] tokens = aTime.split(COLON_SEPARATOR);

        return new StringBuilder(CAPACITY)
                .append(secondsBuildingStrategy.buildFullSegment(tokens[2]))
                .append(TimeBuildingStrategy.LINE_SEPARATOR)
                .append(hourBuildingStrategy.buildFullSegment(tokens[0]))
                .append(TimeBuildingStrategy.LINE_SEPARATOR)
                .append(minuteBuildingStrategy.buildFullSegment(tokens[1])).toString();
    }
}