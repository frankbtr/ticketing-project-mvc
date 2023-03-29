package com.frank.enums;

public enum Status {
    OPEN("open"), IN_PROGRESS("In Progress"), COMPLETE("Completed");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
