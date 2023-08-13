package pl.wszib.travelallowance.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "employee_preference")
public class EmployeePreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_pref_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;
    @Column(name = "local_date")
    private LocalDate localDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "shift")
    private Shift shift;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}