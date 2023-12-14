package com.example.our_graduationproject.Model.Order;

public class FontSelection {



        String font ;
        String image;
        boolean isSelected;

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public FontSelection(String font, String image) {
        this.font = font;
        this.image = image;
    }
}


