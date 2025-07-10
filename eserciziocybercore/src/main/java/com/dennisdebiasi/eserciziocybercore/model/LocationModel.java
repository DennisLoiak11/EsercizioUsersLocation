package com.dennisdebiasi.eserciziocybercore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
public class LocationModel {
    @Id
    private String id;
    private String city;
    private String address;
    private String homeId; //riferimento all'id della Home rispettiva alla location

    //nel costruttore è omesso l'id perche se non viene specificato lo genera MongoDB in automatico
    public LocationModel(String city, String address, String homeId) {
        this.city = city;
        this.address = address;
        this.homeId = homeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }
}
