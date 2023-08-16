package pl.wszib.travelallowance.model;

import jakarta.persistence.*;
import pl.wszib.travelallowance.model.MonthName;
import java.util.Set;

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
    @Column(name = "month_name" )
    private MonthName monthName;
    @OneToMany(mappedBy="month")
    private Set<EmployeePreferences> employeePreferencesSet;


    public Month() {
    }

    public Month(Long id, MonthName monthName, Integer workingDays) {
        this.id=id;
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

