package com.exercise.util;

/**
 * Created by Randeep on 23/06/2017.
 */
public class TLVVo {
    private String type;
    private String length;
    private String value;

    public TLVVo(String type, String length, String value) {
        this.type = type;
        this.length = length;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }
}
