package com.isantospro.interviews.util;

public enum WhoContactEnum {
    CANDIDATE("canidate"),
    RECRUITER("recruiter"),
    COMPANY("company"),
    EMPTY("");

    private final String value;

    WhoContactEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WhoContactEnum getInstance(String value) {
        for (WhoContactEnum whoContactEnum : values()) {
            if (whoContactEnum.getValue().equals(value)) {
                return whoContactEnum;
            }
        }
        return EMPTY;
    }


    public static WhoContactEnum getInstanceByBundle(String bundleValue) {
        for (WhoContactEnum whoContactEnum : values()) {
            if (whoContactEnum.toString().equalsIgnoreCase(bundleValue)) {
                return whoContactEnum;
            }
        }
        return EMPTY;
    }
}
