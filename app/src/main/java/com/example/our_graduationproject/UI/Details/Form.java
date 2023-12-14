package com.example.our_graduationproject.UI.Details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.displayFile;
import com.example.our_graduationproject.Model.Order.LogoOrder_;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.S____DesignName;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.Model.prefernce_values;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.ChooseColor;
import com.example.our_graduationproject.UI.GET_POST.GetScopes;
import com.example.our_graduationproject.UI.GET_POST.GetValues;
import com.example.our_graduationproject.UI.GET_POST.OnScopeReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.OnValuesReceivedListner;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Form extends AppCompatActivity implements OnValuesReceivedListner, OnScopeReceivedListner
{
     private ImageView uploadButton;
    private TextView fileTextView;
    private Uri fileUri;
    TextView price ;

    String selectedIdea,selectedTitle,  selectedVisual,selectedindustry,description1 ,selectedPages,selectedSize,selectedPreference;
    AutoCompleteTextView idea ,industry ,preferenceValue,size ,visualIdentity;
    TextInputLayout ideaDetailes ,industryDetailes,preferenceValueDetailes,
            sizeDetailes,PgesDetailes,descriptionDetailes ,visualIdentityDetailes;
    TextInputEditText description , pages , title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
         uploadButton = findViewById(R.id.upload);
        price =findViewById(R.id.text1);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(); }
        });
       // GetValues.getData(this,prefernce_values,this);
        //GetScopes.getData(this,scope1s,this);
        title=findViewById(R.id.title);
        ideaDetailes=findViewById(R.id.detail_idea);
        industryDetailes=findViewById(R.id.detail_industry);
        preferenceValueDetailes=findViewById(R.id.detail_preference_value);
         visualIdentityDetailes=findViewById(R.id.detail_visual);
          FileName =  findViewById(R.id.txtFileName);
        layoutFileAttachment =  findViewById(R.id.layoutFileAttachment);
        imgFileIcon =  findViewById(R.id.imgFileIcon);

        //descriptionDetailes=findViewById(R.id.description);
        //type=findViewById(R.id.type);
        sizeDetailes=findViewById(R.id.detail_size);
        PgesDetailes=findViewById(R.id.pages_detailes);


        idea=findViewById(R.id.idea);
        initIdea();
       visualIdentity=findViewById(R.id.visual);
       initWithVisualIdentity();
        industry=findViewById(R.id.industry);
        initIdea3();
        preferenceValue=findViewById(R.id.preference_value);
        description=findViewById(R.id.description);
        size=findViewById(R.id.size);
        pages=findViewById(R.id.page);

       ideaDetailes.setHint("There is an idea for your project?");
       sizeDetailes.setHint("size");
        PgesDetailes.setHint("number of pages ");
        preferenceValueDetailes.setHint("type of design ");
        initIdea2();
initDetailsForm();

findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         description1=String.valueOf(description.getText());

        if(description1!=null && !description1.equals("null"))
            Order.setDescreption(description1);
        selectedTitle=String.valueOf(title.getText());

        if(title!=null && !title.equals("null"))
            Order.setTitle(selectedTitle);
        if(!Order.SIMILAR) {
            selectedindustry= String.valueOf(industry.getText());
            if(Order.getTypeOrder().equals("2")||Order.getTypeOrder().equals("3")) {
                selectedPreference = String.valueOf(preferenceValue.getText());
                if (selectedPreference != null)
                    Order.setIndustry(selectedPreference);
            }
            if(selectedindustry!=null)
                Order.setIndustry( selectedindustry);



        }


        if(Order.getName().equals(S____DesignName.LOGO)) {
            selectedIdea = String.valueOf(idea.getText());
            selectedVisual = String.valueOf(visualIdentity.getText());
///////////----logo
            if(selectedVisual != null && !selectedVisual.equals("null")) {
                ((LogoOrder_) Order.order).with_visual = selectedVisual;
            }
            if(selectedIdea != null && !selectedIdea.equals("null")) {
                ((LogoOrder_) Order.order).idea = selectedIdea;
            }
        }
        if(Order.getTypeOrder().equals("2")) {
            selectedSize = String.valueOf(size.getText());
            selectedPages = String.valueOf(pages.getText());
            if(selectedSize!=null)
                Order.setSize(selectedSize);
            if(selectedPages!=null)
                Order.setPages(Integer.parseInt(selectedPages));

        }













      //---------cover--------------





        startActivity( new Intent(getApplicationContext(), ChooseColor.class));






    }
});






    }

    private void initIdea()
    { ArrayList<String> customers = new ArrayList<>();
        customers.add("ready idea ");
        customers.add("An idea that needs discussion");
        customers.add("nothing");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_spinner_item, customers);

        idea.setAdapter(adapter);



    }
    private void initIdea2()
    { ArrayList<String> customers = new ArrayList<>();
        customers.add("post facebook ");
        customers.add("cover facebook");
         ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_spinner_item, customers);

        preferenceValue.setAdapter(adapter);



    }
    private void initIdea3()
    { ArrayList<String> customers = new ArrayList<>();
        customers.add("restaurant");
        customers.add("sport");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_spinner_item, customers);

        industry.setAdapter(adapter);



    }
    private void initWithVisualIdentity()
    {ArrayList<String> getYesOrNo = new ArrayList<>();
        getYesOrNo.add("yes");
        getYesOrNo.add("No");
         ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_spinner_item, getYesOrNo);
         visualIdentity.setAdapter(adapter);
 }
    public void initDetailsForm()
    {if(Order.SIMILAR) {
        preferenceValueDetailes.setVisibility(View.GONE);

        industryDetailes.setVisibility(View.GONE);

    }
        if(Order.getName().equals(S____DesignName.LOGO))
        LogoForm();
        if(Order.getName().equals(S____DesignName.BOOKS))
            coverForm();
        if(Order.getName().equals(S____DesignName.SOCIAL))
            SocialForm();
        if(Order.getName().equals(S____DesignName.PRODUCTS))
            ProductForm();

    }
    public void coverForm()
    { ideaDetailes.setVisibility(View.GONE);
      visualIdentity.setVisibility(View.GONE);





    }
    public void LogoForm()
    {sizeDetailes.setVisibility(View.GONE);
     PgesDetailes.setVisibility(View.GONE);
     preferenceValueDetailes.setVisibility(View.GONE);

    }
    public void ProductForm()
    {ideaDetailes.setVisibility(View.GONE);
        visualIdentity.setVisibility(View.GONE);
        sizeDetailes.setVisibility(View.GONE);
        PgesDetailes.setVisibility(View.GONE);
        preferenceValueDetailes.setVisibility(View.GONE);
    }
    public void SocialForm()
    { ideaDetailes.setVisibility(View.GONE);
        visualIdentity.setVisibility(View.GONE);
        sizeDetailes.setVisibility(View.GONE);
        PgesDetailes.setVisibility(View.GONE);
    }









    ArrayList<Scope1> scope1s = new ArrayList<>();
    String[] preferenceValueNames;
    String[] scopesNames;

    @Override
    public void onScopesReceived(ArrayList<Scope1> list) {
        scope1s=list;
        scopesNames = new String[scope1s.size()];
        for (int i = 0; i < scope1s.size(); i++) {
             scopesNames[i] = scope1s.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Form.this, android.R.layout.simple_spinner_item, scopesNames);

        //Set adapter
        industry.setAdapter(adapter);

    }
ArrayList<com.example.our_graduationproject.Model.prefernce_values> prefernce_values= new ArrayList< >();



    @Override
    public void onValueReceived(ArrayList<prefernce_values> list) {
        preferenceValueNames = new String[prefernce_values.size()];
        for (int i = 0; i < prefernce_values.size(); i++) {
            preferenceValueNames[i] = prefernce_values.get(i).getName();
        }

        preferenceValue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the clicked item's position
                prefernce_values clickedItem = (prefernce_values) parent.getItemAtPosition(position);
                Order.setPrice(Integer.parseInt(Order.getPrice()+clickedItem.getPrice()));
               price.setText(clickedItem.getPrice());
                // Perform any necessary actions with the clicked item position
                Toast.makeText(Form.this, "Clicked item: " + clickedItem + ", Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });










        }    private static final int FILE_REQUEST_CODE = 1;

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Accept all file types
        startActivityForResult(intent, FILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //
        File file = null;
        String filePath = null;
        Uri fileUri  =null ;

        if (requestCode == FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                fileUri = data.getData();
                file = null;

                if (fileUri != null) {
                    Order.order.setUrl(fileUri);
                    if (ContentResolver.SCHEME_CONTENT.equals(fileUri.getScheme())) {
                        ContentResolver contentResolver = getContentResolver();
                        filePath = null;

                        try (InputStream inputStream = contentResolver.openInputStream(fileUri)) {
                            if (inputStream != null) {
                                // Create a temporary file using a unique name
                                File tempFile = File.createTempFile("temp", null, getCacheDir());
                                // Copy the content of the input stream to the temporary file
                                copyInputStreamToFile(inputStream, tempFile);
                                // Set the temporary file as the final file
                                file = tempFile;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (ContentResolver.SCHEME_FILE.equals(fileUri.getScheme())) {
                      file = new File(fileUri.getPath());
                    }
                }

                if (file != null && file.exists()) {
                    Order.setFile(file);
Order.setPrice(Order.getPrice()+10)
;price.setText("price : "+Order.getPrice());
                   new displayFile(Form.this,FileName,imgFileIcon).displayFileAttachment(file, fileUri);
                    Toast.makeText(Form.this, "  exist", Toast.LENGTH_SHORT).show();
                    // Continue processing the message or perform any required actions
                    // ...
                } else {
                    Toast.makeText(Form.this, "File does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        }





     }

      LinearLayout layoutFileAttachment;
    ImageView imgFileIcon;
    TextView FileName;





    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }








    // Add the uploadFile method here

}
