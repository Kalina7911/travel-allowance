package pl.wszib.travelallowance.model;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "index")
    private Integer index;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<EmployeePreferences> employeePreferences;


    public User() {

    }

    public User(String name, Integer index, String password, Long id) {
        this.name = name;
        this.index = index;
        this.password = password;
        this.id = id;
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
