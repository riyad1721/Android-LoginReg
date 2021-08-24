package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText SignInEmailEdittex, SignInPasswordText;
    private TextView SignInTextview;
    private Button SignInButton;
     String id1="1721966";
    String id2="1731977";
     String password1="1111";
    String password2="2222";
    String a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Log In");

        SignInEmailEdittex = findViewById(R.id.etemail);
        SignInPasswordText =findViewById(R.id.mypass);
        SignInButton =findViewById(R.id.btnlogin);
       // SignInTextview = findViewById(R.id.createnewac);
        //a =  SignInEmailEdittex.getText().toString().trim();
        //b= SignInPasswordText.getText().toString().trim();

       // SignInTextview.setOnClickListener((View.OnClickListener) this);
        SignInButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        a =  SignInEmailEdittex.getText().toString().trim();
        b= SignInPasswordText.getText().toString().trim();
        if(a.isEmpty()&& b.isEmpty()) {
            SignInEmailEdittex.requestFocus();
            SignInPasswordText.requestFocus();
            return;
        }

        switch (v.getId()){


            case R.id.btnlogin: {



                    if (a.equals(id1)  && b.equals(password1)  ) {
                        Intent intent = new Intent(getApplicationContext(), VotiingSection.class);
                        startActivity(intent);
                    }
                    else if (a.equals(id2)  && b.equals(password2) ) {
                            Intent intent = new Intent(getApplicationContext(), VotiingSection.class);
                            startActivity(intent);


                        }




                  else {
                    Toast.makeText(getApplicationContext(), " your Id and password is invalid", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            //case  R.id.createnewac:
                //Intent intent2 = new Intent(getApplicationContext(),SignUpActivity.class);
               // startActivity(intent2);
               // break;


        }

    }
}