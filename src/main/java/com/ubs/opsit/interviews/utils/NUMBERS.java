package com.ubs.opsit.interviews.utils;

/**
 * NUMBERS
 *
 * @author Hayk Hovhannisyan
 */

public enum NUMBERS {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11);

    private final int value;

    NUMBERS(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}