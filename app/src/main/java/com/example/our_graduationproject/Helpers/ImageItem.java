package com.example.our_graduationproject.Helpers;

import java.io.Serializable;

public class ImageItem  implements Serializable {

     boolean isSelected = false ;
     public String image="" ;
     int imageInt;

    public int getImageInt() {
        return imageInt;
    }

    public void setImageInt(int imageInt) {
        this.imageInt = imageInt;
    }

    private String title;
    private int key_id;
    private int likes;
    private boolean favStatus;
    int scopId ;
    int typeId;
    int prefernceId ;
    int prefernceValueId  ;
    int price ;
String scope;
String preferece,preferenceValue;

    public boolean isFavStatus() {
        return favStatus;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getPreferece() {
        return preferece;
    }

    public void setPreferece(String preferece) {
        this.preferece = preferece;
    }

    public String getPreferenceValue() {
        return preferenceValue;
    }

    public void setPreferenceValue(String preferenceValue) {
        this.preferenceValue = preferenceValue;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getScopId() {
        return scopId;
    }

    public void setScopId(int scopId) {
        this.scopId = scopId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPrefernceId() {
        return prefernceId;
    }

    public void setPrefernceId(int prefernceId) {
        this.prefernceId = prefernceId;
    }

    public int getPrefernceValueId() {
        return prefernceValueId;
    }

    public void setPrefernceValueId(int prefernceValueId) {
        this.prefernceValueId = prefernceValueId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ImageItem() {
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public ImageItem(String image, String title,
                      int key_id, boolean favStatus,
                      int scopId, int typeId,
                      int prefernceId, int prefernceValueId,
                      int price) {
         this.image = image;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.scopId = scopId;
        this.typeId = typeId;
        this.prefernceId = prefernceId;
        this.prefernceValueId = prefernceValueId;
        this.price = price;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public boolean getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(boolean favStatus) {
        this.favStatus = favStatus;
    }
}
