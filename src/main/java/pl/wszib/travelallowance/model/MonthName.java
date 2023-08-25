package pl.wszib.travelallowance.model;

import java.time.format.TextStyle;
import java.util.Locale;

public enum MonthName {

    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");


    private final String displayName;

    MonthName(String displayName) {
        this.displayName = displayName;
    }



    public String getDisplayName() {
        return displayName;
    }

}
