package com.github.raunysouza.wwz.ms;

import com.github.raunysouza.wwz.model.Survivor;

/**
 * @author raunysouza
 */
public class SurvivorResponse {

    private Long id;
    private String name;
    private String gender;
    private double latitude;
    private double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static SurvivorResponse fromSurvivor(Survivor survivor) {
        SurvivorResponse response = null;

        if (survivor != null) {
            response = new SurvivorResponse();
            response.id = survivor.getId();
            response.name = survivor.getName();
            response.gender = survivor.getGender().name();
            response.latitude = survivor.getLastLocation().getLatitude();
            response.longitude = survivor.getLastLocation().getLongitude();
        }

        return response;
    }
}
