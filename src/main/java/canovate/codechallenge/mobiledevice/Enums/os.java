package canovate.codechallenge.mobiledevice.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum os {
    Android("Android"),iOS("iOS");
    private String name;
    os(String name) {
        this.name= name;
    }
    @JsonValue
    public String getName() {
        return name;
    }

}
