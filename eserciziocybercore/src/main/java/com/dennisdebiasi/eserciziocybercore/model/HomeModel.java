package com.dennisdebiasi.eserciziocybercore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "homes")
public class HomeModel {
    @Id
    private String id;
    private String name;

    //nel costruttore ometto l'id perche se non viene specificato lo genera MongoDB in automatico
    public HomeModel(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
