package com.example.nagaraj.callapp;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button btn;
    private EditText no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        no=(EditText)findViewById(R.id.editText);
        btn.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.button){
          String  number;
            number=no.getText().toString();
            try {
                Intent callactivity = new Intent(Intent.ACTION_CALL);
                callactivity.setData(Uri.parse("tel:"+number));
                try {
                    startActivity(callactivity);
                    finish();
                }catch (SecurityException e){
                    Toast.makeText(getApplicationContext(),"error"+number,Toast.LENGTH_SHORT).show();
                }
            }catch (android.content.ActivityNotFoundException e){
                Toast.makeText(getApplicationContext(),"error"+number,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
