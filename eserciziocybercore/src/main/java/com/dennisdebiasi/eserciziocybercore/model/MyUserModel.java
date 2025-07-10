package com.dennisdebiasi.eserciziocybercore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class MyUserModel {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private List<String> idLocations; //riferimento agli id delle locations associate all'utente

    public MyUserModel(String username, String firstName, String lastName, List<String> idLocations) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idLocations = idLocations;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getIdLocations() {
        return idLocations;
    }

    public void setIdLocations(List<String> idLocations) {
        this.idLocations = idLocations;
    }
}
