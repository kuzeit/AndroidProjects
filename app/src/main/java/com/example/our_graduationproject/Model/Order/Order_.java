package com.example.our_graduationproject.Model.Order;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.FontSelection;
import com.example.our_graduationproject.Controller.GallaryAdapter;
import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.GET_POST.GetGallaryDesignes;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order_ implements Serializable
{
String fileCustomer ,imageArtboard ;
public int item_id;
    public String getFileCustomer() {
        return fileCustomer;
    }

    public void setFileCustomer(String fileCustomer) {
        this.fileCustomer = fileCustomer;
    }

    public String getImageArtboard() {
        return imageArtboard;
    }

    public void setImageArtboard(String imageArtboard) {
        this.imageArtboard = imageArtboard;
    }

    public String getStringFile() {
        return stringFile;
    }
String fileName ;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setStringFile(String stringFile) {
        this.stringFile = stringFile;
    }
int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String title =null;
    String[] colorss,  fontss;

    public String[] getColorss() {
        return colorss;
    }

    public void setColorss(String[] colorss) {
        this.colorss = colorss;
    }

    public String[] getFontss() {
        return fontss;
    }

    public void setFontss(String[] fontss) {
        this.fontss = fontss;
    }

    public List<FontSelection> getFontSelections() {
        return fontSelections;
    }

    public void setFontSelections(List<FontSelection> fontSelections) {
        this.fontSelections = fontSelections;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public File getFile() {
        return file;
    }
Uri Url ;

    public Uri getUrl() {
        return Url;
    }

    public void setUrl(Uri url) {
        Url = url;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getArtBoard() {
        return artBoard;
    }

    public void setArtBoard(File artBoard) {
        this.artBoard = artBoard;
    }
String staues;

    public String getStaues() {
        return staues;
    }

    public void setStaues(String staues) {
        this.staues = staues;
    }

    String stringFile ;
    public int scope_id=0;
    File image  =null;
    public   String typeOrder ="0";
    public   String name ="";
    public   int price =0;
    public   String slug ="";
    public Designer selectedDesigner =new Designer();
    public    List<ColorSelection> selectedColors = new ArrayList<>();
    public    List<FontSelection> fontSelections = new ArrayList<>();

    public   String selectedFont="";
    public    String idea="" ;
    public    String industry="";

    public   String descreption="";

    public   boolean similar =false;
    public   String type ="0";

         int preferebce_id =0;
      int prefernce_value_id =0;
        String preferebce ="";
       String prefernce_values ="";
     public String size;
    public  int sizeId;
    public  int designer_id;

    public int getDesigner_id() {
        return designer_id;
    }

    public void setDesigner_id(int designer_id) {
        this.designer_id = designer_id;
    }

    File file =null;
File artBoard=null;
    public Context context;
    public TextView textView;

    public Order_(Order_ order )
    { this.file=order.file;
        this.item_id=order.item_id;
        this.artBoard=order.artBoard;
        this.typeOrder = order.typeOrder;
        this.name = order.name;
        this.price = order.price;
        this.slug = order.slug;
        this.fontss = order.fontss;
        this.colorss = order.colorss;

        this.selectedDesigner = order.selectedDesigner;
        this.selectedColors = order.selectedColors;
        this.selectedFont = order.selectedFont;
        this.idea = order.idea;
        this.industry = order.industry;
        this.descreption = order.descreption;
        this.similar = order.similar;
        this.type = order.type;
        this.preferebce_id = order.preferebce_id;
        this.prefernce_value_id = order.prefernce_value_id;
        this.preferebce = order.preferebce;
        this.prefernce_values = order.prefernce_values;
        this.size = order.size;
        this.context = order.context;
        this.textView = order.textView;
    }

    public int getScope_id() {
        return scope_id;
    }

    public void setScope_id(int scope_id) {
        this.scope_id = scope_id;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Designer getSelectedDesigner() {
        return selectedDesigner;
    }

    public void setSelectedDesigner(Designer selectedDesigner) {
        this.selectedDesigner = selectedDesigner;
    }

    public List<ColorSelection> getSelectedColors() {
        return selectedColors;
    }

    public void setSelectedColors(List<ColorSelection> selectedColors) {
        this.selectedColors = selectedColors;
    }

    public String getSelectedFont() {
        return selectedFont;
    }

    public void setSelectedFont(String selectedFont) {
        this.selectedFont = selectedFont;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public boolean isSimilar() {
        return similar;
    }

    public void setSimilar(boolean similar) {
        this.similar = similar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPreferebce_id() {
        return preferebce_id;
    }

    public void setPreferebce_id(int preferebce_id) {
        this.preferebce_id = preferebce_id;
    }

    public int getPrefernce_value_id() {
        return prefernce_value_id;
    }

    public void setPrefernce_value_id(int prefernce_value_id) {
        this.prefernce_value_id = prefernce_value_id;
    }

    public String getPreferebce() {
        return preferebce;
    }

    public void setPreferebce(String preferebce) {
        this.preferebce = preferebce;
    }

    public String getPrefernce_values() {
        return prefernce_values;
    }

    public void setPrefernce_values(String prefernce_values) {
        this.prefernce_values = prefernce_values;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getTextView() {
        return textView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public Order_() {
    }}
