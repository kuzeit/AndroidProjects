package com.example.our_graduationproject.CustomSpinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.our_graduationproject.R;

public class spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /** Called when the activity is first created. */
    EditText num1, num2;
    Button button01;
    TextView tv1;
    ImageView iv1;
    Spinner spinOps;
    String[] ops={"Choose operation","+","-","*","/"};
    String opselected;
    double a, b, c;
    private View.OnClickListener myClickListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            a=Double.parseDouble(num1.getText().toString());
            b=Double.parseDouble(num2.getText().toString());
            if (opselected=="+"){c=a+b; tv1.setText(Double.toString(c));}
            else if (opselected=="-"){c=a-b; tv1.setText(Double.toString(c));}
            else if (opselected=="*"){c=a*b; tv1.setText(Double.toString(c));}
            else if (opselected=="/"){c=a/b; tv1.setText(Double.toString(c));}
            else {tv1.setText("Please select the operation");}
            //tv1 = (TextView)findViewById(R.id.TextView01);


        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        tv1 = (TextView)findViewById(R.id.TextView01);
        //iv1= (ImageView)findViewById(R.id.);//try imageview

        button01 = (Button)findViewById(R.id.Button01);
        button01.setText("Display result");
        button01.setOnClickListener(myClickListener);

        num1 = (EditText)findViewById(R.id.EditText01);
        num1.setText("");
        num2 = (EditText)findViewById(R.id.EditText02);
        num2.setText("");

        //list of operations
        spinOps = (Spinner)findViewById(R.id.Spinner01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, ops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOps.setAdapter(adapter);
        spinOps.setOnItemSelectedListener(this);
         spinOps.setPrompt("Select your favorite Planet!");


    }
    public void onItemSelected (AdapterView<?> p,View v,int position,long id) {
        opselected=ops[position];
        tv1.setText("You have selected " + opselected);
    }
    public void onNothingSelected(AdapterView<?> p) {
        tv1.setText("Please select ops");
    }
}