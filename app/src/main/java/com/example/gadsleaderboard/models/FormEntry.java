package com.example.gadsleaderboard.models;

public class FormEntry {
    private Throwable mThrowable;
    private String mString;

    public String getString() {
        return mString;
    }

    public FormEntry(String string) {
        mString = string;
    }

    public FormEntry(Throwable throwable) {
        mThrowable = throwable;
    }


    public Throwable getThrowable() {
        return mThrowable;
    }
}
