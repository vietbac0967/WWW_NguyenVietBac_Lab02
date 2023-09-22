package com.example.demojpa.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    TERMINATED(0),
    IN_ACTIVE(-1);
    private final int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
