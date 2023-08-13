package pl.wszib.travelallowance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "month")
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="month_id")
    private Long id;
    @Column(name="working_days")
    private Integer workingDays;
    @Enumerated(EnumType.STRING)
    @Column(name = "month_name")
    private MonthName monthName;


    public Month() {
    }

    public Month(MonthName monthName, Integer workingDays) {
        this.workingDays = workingDays;
        this.monthName = monthName;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

    public MonthName getMonthName() {
        return monthName;
    }

    public void setMonthName(MonthName monthName) {
        this.monthName = monthName;
    }
}

