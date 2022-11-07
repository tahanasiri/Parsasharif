package com.parsasharif.logtime.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class MonthObject {
    @NotEmpty(message = "months is required")
    private List<Long> months;

    public MonthObject() {
    }

    public List<Long> getMonths() {
        return months;
    }

    public void setMonths(List<Long> months) {
        this.months = months;
    }
}
