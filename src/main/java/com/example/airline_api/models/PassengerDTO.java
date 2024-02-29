package com.example.airline_api.models;

public class PassengerDTO {

    private String name;
    private String email;
    private Long flightId;

    public PassengerDTO(String name, String email, Long flightId) {
        this.name = name;
        this.email = email;
        this.flightId = flightId;
    }

    public PassengerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
