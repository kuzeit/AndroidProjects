package com.example.our_graduationproject.Model;

import java.io.Serializable;

public class Designer  implements Serializable {

    int id ;
    String profile ;
   String name="" ;
   String description;
   Double rating ;
   int numberTasks;
   int categryId;
   String category;
   String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Designer(int id, String profile, String name, String description, Double rating, int numberTasks, String email, boolean isSelected) {
        this.id = id;
        this.profile = profile;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.numberTasks = numberTasks;
        this.email = email;
        this.isSelected = isSelected;
    }

//    public Designer(int id, int profile, String name, String description, Double rating, int numberTasks, int categryId, String category, String email, boolean isSelected) {
//        this.id = id;
//        this.profile = profile;
//        this.name = name;
//        this.description = description;
//        this.rating = rating;
//        this.numberTasks = numberTasks;
//        this.categryId = categryId;
//        this.category = category;
//        this.email = email;
//        this.isSelected = isSelected;
//    }

    public int getNumberTasks() {
        return numberTasks;
    }

    public void setNumberTasks(int numberTasks) {
        this.numberTasks = numberTasks;
    }

    public int getCategryId() {
        return categryId;
    }

    public void setCategryId(int categryId) {
        this.categryId = categryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    boolean isSelected ;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Designer() {
    }



    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
