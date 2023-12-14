package com.example.our_graduationproject.Model;

public class ColorSelection {
    int color ;
    boolean isSelected;
int id ;
    public ColorSelection(int color) {
        this.color = color;
    }

    public ColorSelection( int id,int color) {
        this.color = color;
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
