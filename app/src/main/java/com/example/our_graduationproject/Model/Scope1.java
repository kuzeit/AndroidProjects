package com.example.our_graduationproject.Model;

public class Scope1 {
    int id ;
    String name ;
    String sluge;

    public Scope1() {
    }

    public int getId() {
        return id;
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

    public String getSlug() {
        return sluge;
    }

    public void setSlug(String sluge) {
        this.sluge = sluge;
    }

    public Scope1(int id, String name, String sluge) {
        this.id = id;
        this.name = name;
        this.sluge = sluge;
    }
}
