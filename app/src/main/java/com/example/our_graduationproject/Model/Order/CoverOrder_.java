package com.example.our_graduationproject.Model.Order;


public class CoverOrder_ extends  Order_{
    public int pages;
    public String size ;

public String typeFoodList;
    public CoverOrder_() {
        name= S____DesignName.BOOKS;
        typeOrder= String.valueOf(2);

    }











  }
//    @Override
//    public void OnClick(AdapterView<?> parent, View view, int position, long id) {
//        super.OnClick(parent, view, position, id);
//
//
//    }
//    @Override
//    public void initSpinners(CustomSpinner spinner1, CustomSpinner spinner2)
//    {
//        super.initSpinners(spinner1, spinner2);
//        spinner1.setVisibility(View.VISIBLE);
//
//
//        textView.setText(S____DesignName.BOOKS);
//        intent = new Intent(context, CoverDetailes_.class);
//}
//    public ArrayList<ImageItem> getImages(GridView gridView1)
//    {  gridView = gridView1;
//        this.listGallary= S_____FillIImagesGallary.AllCover();
//
//        gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//        gridView.setAdapter(gallaryAdapter);
//
//        return  listGallary;
//    }
//
//
//    @Override
//    public void OnClick(View view, int position) {
//        super.OnClick(view,position);
//            if (position==1)
//            {this.listGallary= S_____FillIImagesGallary.All_BOOK_CIVER();}
//            if (position==0)
//            {this.listGallary= S_____FillIImagesGallary.AllCover();}
//
//            if (position==2)
//            {this.listGallary= S_____FillIImagesGallary.All_Magazine();}
//            if (position==3)
//            {this.listGallary= S_____FillIImagesGallary.All_Menu();}
//
//            gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//            gridView.setAdapter(gallaryAdapter);
//
//            gallaryAdapter.notifyDataSetChanged();
//
//        if (Order.order.preferebce1_id==1)
//            BookCover();
//        else if (Order.order.preferebce1_id==3)
//            Menu();
//        else if(Order.order.preferebce1_id==2)
//            Magazine();  }
//
//
//    void Magazine( )
//    {
//
//
//        list1= Arrays.asList(S_____SpinnersArray.TYPE_MAGAZINE1);
//
//        spinnrer(spinner1, S_____SpinnersArray.TYPE_MAGAZINE1);
//        textView.setText("Magazine");
//
//
//    }
//    void BookCover( )
//    {   list1= Arrays.asList(S_____SpinnersArray.BOOK_COVERS);
//
//        spinnrer(spinner1, S_____SpinnersArray.BOOK_COVERS);
//        textView.setText("Book cover");
//
//    }
//    void Menu( )
//    {list1= Arrays.asList(S_____SpinnersArray.Menu);
//
//        spinnrer(spinner1, S_____SpinnersArray.Menu);
//        textView.setText("Menu");
//
//    }
//
//


