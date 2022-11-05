package com.parsasharif.logtime.dto;


public class TaskDefinition {
    private String cronExpression;

    public TaskDefinition() {
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
