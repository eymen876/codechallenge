package canovate.codechallenge.mobiledevice;

import com.fasterxml.jackson.annotation.JsonValue;

public enum os {
    Android("Android"),iOS("iOs");
    private String name;
    os(String name) {
        this.name= name;
    }
    @JsonValue
    public String getName() {
        return name;
    }
}
