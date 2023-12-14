package com.example.our_graduationproject.Controller;

public class FontSelection {
String image ;
int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String font   ;
        boolean isSelected;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFont() {
        return font;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public FontSelection(int id,String image,  String font) {
        this.image = image;
        this.id = id;
        this.font = font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
