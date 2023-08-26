package pl.wszib.travelallowance.services;

public class NextMonthModel {

    private Integer workingDays;
    private String monthName;

    public NextMonthModel() {
    }

    public NextMonthModel(Integer workingDays, String monthName) {
        this.workingDays = workingDays;
        this.monthName = monthName;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
