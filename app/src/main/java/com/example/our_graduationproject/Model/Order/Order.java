package com.example.our_graduationproject.Model.Order;

import android.view.View;
import android.widget.AdapterView;

import com.example.our_graduationproject.Controller.FontSelection;
import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Designer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Order
{

    public static List<Order_> orderS =new ArrayList<>();
   public static boolean SIMILAR =false;

public static Order_ order ;

    public static void setSIMILAR(boolean SIMILAR) {
        Order.SIMILAR = SIMILAR;
    }

    public static File getFile() {
        return order.file;
    }

    public static void setFile(File file) {
        Order.order.file = file;
    }

    public static File getArtBoard() {
        return order.artBoard;
    }

    public static void setArtBoard(File artBoard) {
        Order.order.artBoard = artBoard;
    }

    public static List<Order_> getOrderS() {
        return orderS;
    }

    public static void setOrderS(List<Order_> orderS) {
        Order.orderS = orderS;
    }

    public static String[] getColorss() {
        return order.colorss;
    }

    public static void setColorss(String[] colorss) {
        Order.order.colorss = colorss;
    }

    public static String[] getFontss() {
        return order.fontss;
    }

    public static void setFontss(String[] fontss) {
        Order.order.fontss = fontss;
    }

    public static List<com.example.our_graduationproject.Controller.FontSelection> getFontSelections() {
        return order.fontSelections;
    }

    public static void setFontSelections(List<FontSelection> fontSelections) {
        Order.order.fontSelections = fontSelections;
    }

    public int getSizeId() {
        return order.sizeId;
    }

    public void setSizeId(int sizeId) {
        order.sizeId = sizeId;
    }

    public  static int getScope_id() {
        return order.scope_id;
    }

    public  static void setScope_id(int scope_id) {
        order.scope_id = scope_id;
    }

    int scope_id ;

    public  static File getImage() {
        return order.image;
    }

    public static void setImage(File image) {
        order.image = image;
    }

    public  static String getPreferebce() {
        return order.preferebce;
    }

    public  static void setPreferebce(String preferebce) {
        order.preferebce = preferebce;
    }

    public  static String getPrefernce_values() {
        return order.prefernce_values;
    }

    public  static void setPrefernce_values(String prefernce_values) {
        order.prefernce_values = prefernce_values;
    }

    public  static int getPreferebce_id() {
        return order.preferebce_id;
    }

    public  static void setPreferebce_id(int preferebce1_id) {
        order.preferebce_id = preferebce1_id;
    }

    public  static int getPrefernce_value_id() {
        return order.prefernce_value_id;
    }

    public  static void setPrefernce_value_id(int prefernce_value_id) {
        order.prefernce_value_id = prefernce_value_id;
    }




    public Order(int i ) {
        System.out.println("type++"+i);
   if (i==1) {
       order = new LogoOrder_();
       //detailes = new D();
   }else if (i==2) {
    order = new CoverOrder_();
 }
       else if (i==3) {
            order = new SocialOrder_();
         }
   else if (i==4) {
            order = new ProductOrder_();
         }


    }


    public static  String getTitle() {
        return order.title;
    }

    public static  void setTitle(String title) {
        order.title = title;
    }

    public static void setOrder(Order_ order) {
        Order.order = order;
    }

    public static void setTypeOrder(String typeOrder) {
        Order.order.typeOrder = typeOrder;
    }
    public static void setSlug(String slug) {
        Order.order.slug = slug;
    }
    public static String getSlug() {
        return Order.order.slug;
    }
    public static void setName(String name) {
        Order.order.name = name;
    }

    public static void setPrice(int price) {
        Order.order.price = price;
    }

    public static void setSelectedDesigner(Designer selectedDesigner) {
        Order.order.selectedDesigner = selectedDesigner;
    }

    public static void setSelectedColors(List<ColorSelection> selectedColors) {
        Order.order.selectedColors = selectedColors;
    }

    public static void setSelectedFont(String selectedFont) {
        Order.order.selectedFont = selectedFont;
    }

    public static void setIdea(String idea) {
        Order.order.idea = idea;
    }

    public static void setIndustry(String industry) {
        Order.order.industry = industry;
    }


    public static void setDescreption(String descreption) {
        Order.order.descreption = descreption;
    }

    public static void setSimilar(boolean similar) {
        Order.order.similar = similar;
    }

    public static void setType(String type) {
        Order.order.type = type;
    }
































    public static boolean isSIMILAR() {
        return order.similar;
    }

    public static Order_ getOrder() {
        return order;
    }

    public static String getTypeOrder() {
        return order.typeOrder;
    }

    public static String getName() {
        return order.name;
    }

    public static int getPrice() {
        return order.price;
    }

    public static Designer getSelectedDesigner() {
        return order.selectedDesigner;
    }

    public static List<ColorSelection> getSelectedColors() {
        return order.getSelectedColors();
    }

    public static String getSelectedFont() {
        return order.selectedFont;
    }

    public static String getIdea() {
        return order.idea;
    }

    public static String getIndustry() {
        return order.industry;
    }
     public static String getDescreption() {
        return order.descreption;
    }

    public static boolean isSimilar() {
        return order.similar;
    }

    public static String getType() {
        return order.type;
    }


    public static void setPages(int pages) {
        ((CoverOrder_)Order.order).pages=pages;
    }

    public static void setSize(String selectedSize) {
        ((CoverOrder_)Order.order).size=selectedSize;
    }
}

