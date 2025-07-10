package com.dennisdebiasi.eserciziocybercore.model;

//classe creata per restituire la lista di location del metodo GET e visualizzare anche il nome della casa
public class LocationResponseModel {
    private String city;
    private String address;
    private String home;

    public LocationResponseModel(String city, String address, String home) {
        this.city = city;
        this.address = address;
        this.home = home;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
