package com.example.our_graduationproject.Model;

public class DesignType {
 String  image ;
 String type;
int price;
int id ;
int img;
String slug;

 public int getImg() {
  return img;
 }

 public void setImg(int img) {
  this.img = img;
 }

 public String getSlug() {
  return slug;
 }

 public void setSlug(String slug) {
  this.slug = slug;
 }

 public DesignType() {
 }

 public int getPrice() {
  return price;
 }

 public void setPrice(int price) {
  this.price = price;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public DesignType(String image, String type, int price, int id, String slug) {
  this.image = image;
  this.type = type;
  this.price = price;
  this.id = id;
  this.slug = slug;
 }

 public DesignType(String image, String type, int price, int id) {
  this.image = image;
  this.type = type;
  this.price = price;
  this.id = id;
 }



 public String getImage() {
  return image;
 }

 public void setImage(String image) {
  this.image = image;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }
}
