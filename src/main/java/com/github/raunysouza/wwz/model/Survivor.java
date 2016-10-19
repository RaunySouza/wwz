package com.github.raunysouza.wwz.model;

import javax.persistence.*;

/**
 * @author raunysouza
 */
@Entity
@Table(name = "survivor")
public class Survivor extends PersistableEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private Gender gender;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Location lastLocation;

    public enum Gender {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
}
