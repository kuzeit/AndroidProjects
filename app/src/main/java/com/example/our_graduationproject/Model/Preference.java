package com.example.our_graduationproject.Model;

import java.util.ArrayList;
import java.util.List;

public class Preference {
int type_id;
String image;
String price;
int id ;
String name;

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefernce_values(List<com.example.our_graduationproject.Model.prefernce_values> prefernce_values) {
        this.prefernce_values = prefernce_values;
    }

    List<prefernce_values> prefernce_values;

    public Preference(int type_id, String image, String price, int id, String name, List<prefernce_values> prefernce_values) {
        this.type_id = type_id;
        this.image = image;
        this.price = price;
        this.id = id;
        this.name = name;
        this.prefernce_values = prefernce_values;
    }

    public int getType_id() {
        return type_id;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public List<prefernce_values> getPrefernce_values() {
        return prefernce_values;
    }
}
