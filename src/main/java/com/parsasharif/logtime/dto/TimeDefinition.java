package com.parsasharif.logtime.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class TimeDefinition {
    @NotEmpty(message = "Cron Expression is required")
    @Pattern(regexp = "^(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?))(,(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?)))*\\s(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?))(,(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?)))*\\s(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?))(,(((\\*|(\\d\\d?))(\\/\\d\\d?)?)|(\\d\\d?\\-\\d\\d?)))*\\s(\\?|(((\\*|(\\d\\d?L?))(\\/\\d\\d?)?)|(\\d\\d?L?\\-\\d\\d?L?)|L|(\\d\\d?W))(,(((\\*|(\\d\\d?L?))(\\/\\d\\d?)?)|(\\d\\d?L?\\-\\d\\d?L?)|L|(\\d\\d?W)))*)\\s(((\\*|(\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))(\\/\\d\\d?)?)|((\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-(\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)))(,(((\\*|(\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))(\\/\\d\\d?)?)|((\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)\\-(\\d|10|11|12|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC))))*\\s(((\\*|([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?)(\\/\\d\\d?)?)|(([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?\\-([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?)|([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?#([1-5]))(,(((\\*|([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?)(\\/\\d\\d?)?)|(([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?\\-([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?)|([0-7]|MON|TUE|WED|THU|FRI|SAT|SUN)L?#([1-5])))*$")
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
