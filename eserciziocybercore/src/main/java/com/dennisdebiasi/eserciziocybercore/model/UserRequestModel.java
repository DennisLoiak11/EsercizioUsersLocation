package com.dennisdebiasi.eserciziocybercore.model;

import java.util.List;

//classe che mi servirà per costruire l'oggetto da inserire nel body della richiesta POST
public class UserRequestModel {
    private String username;
    private String firstName;
    private String lastName;
    private List<LocationRequestModel> locations;

    public static class LocationRequestModel{
        private String city;
        private String address;
        private HomeRequestModel home;

        public static class HomeRequestModel{
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
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

        public HomeRequestModel getHome() {
            return home;
        }

        public void setHome(HomeRequestModel home) {
            this.home = home;
        }
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

    public List<LocationRequestModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationRequestModel> locations) {
        this.locations = locations;
    }
}
