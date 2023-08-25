package pl.wszib.travelallowance.model;

import java.time.LocalDate;

public class EmployeePreferencesModel {
    private Integer index;
    private String month;
    private LocalDate localDate;
    private Shift shift;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public MonthName getMonth() {
        return MonthName.valueOf(month);
    }



    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Shift getShift() {

       return shift;

    }


    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public void setMonth(String month) {

        this.month = month;
    }
}
