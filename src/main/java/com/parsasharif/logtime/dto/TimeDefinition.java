package com.parsasharif.logtime.dto;


public class TimeDefinition {
    private String cronExpression;

    public TimeDefinition() {
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
