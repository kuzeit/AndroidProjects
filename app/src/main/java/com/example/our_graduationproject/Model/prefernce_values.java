package com.example.our_graduationproject.Model;

public class prefernce_values {


    int preference_id;
    String image;
    String price;
    int id ;
String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public prefernce_values(int preference_id, String image, String price, int id, String name) {
        this.preference_id = preference_id;
        this.image = image;
        this.price = price;
        this.id = id;
        this.name = name;
    }

    public int getPreference_id() {
        return preference_id;
    }

    public void setPreference_id(int preference_id) {
        this.preference_id = preference_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
