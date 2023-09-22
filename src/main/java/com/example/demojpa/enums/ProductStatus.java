package com.example.demojpa.enums;

public enum ProductStatus {
    ACTIVE(1),
    TERMINATED(0),
    IN_ACTIVE(-1);
    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
