package com.github.raunysouza.wwz.ms;

import javax.validation.constraints.*;

/**
 * @author raunysouza
 */
public class SurvivorRequest {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Min(1)
    @Max(200)
    private int age;

    @NotNull
    @Pattern(regexp = "(MALE|FEMALE)")
    private String gender;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
