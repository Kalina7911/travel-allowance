package pl.wszib.travelallowance.model;


import jakarta.persistence.*;

import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue
    @Column (name = "user_id")
    private Long id;
    private String name;
    private Integer index;
    private String password;


    @OneToMany(mappedBy = "user")
    private Set<EmployeePreferences> employeePreferences;


    public User() {

    }

    public User(String name, Integer index, String password) {
        this.name = name;
        this.index = index;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
