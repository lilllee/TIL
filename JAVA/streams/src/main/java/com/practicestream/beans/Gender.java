package com.practicestream.beans;

import java.util.Arrays;

public enum Gender {
    MALE("남자"), FEMALE("여자"), UnknownError("알수없음");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public static Gender find(String description) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.description.equals(description))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("없음"));
    }

}
