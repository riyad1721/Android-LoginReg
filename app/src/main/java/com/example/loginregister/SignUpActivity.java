package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText SignUpEmailEdittex, SignUpPasswordText;
    private TextView SignUpTextview;
    private Button SignUpButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("DATA");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");


        SignUpEmailEdittex = findViewById(R.id.editEmail);
        SignUpPasswordText =findViewById(R.id.editPass);
        SignUpButton =findViewById(R.id.buttonAcount);
        SignUpTextview = findViewById(R.id.textView);

        SignUpTextview.setOnClickListener((View.OnClickListener) this);
        SignUpButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonAcount:
                userRegister();
                break;
            case  R.id.textView:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;


        }

    }

    private void userRegister() {
        String email =  SignUpEmailEdittex.getText().toString().trim();
        String password = SignUpPasswordText.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            SignUpEmailEdittex.setError("জাতীয় পরিচয়পত্র নাম্বারটি দিন");
            SignUpEmailEdittex.requestFocus();
            return;
        }


        //checking the validity of the password
        if(password.isEmpty())
        {
            SignUpPasswordText.setError("পাসওয়ার্ড");
            SignUpPasswordText.requestFocus();
            return;
        }
        //creating an unique user id
        Information savedata = new Information(email,password);
        DatabaseReference myRef = database.getReference("DATA");
        //Toast.makeText(getApplicationContext(),"Age:"+age+"; Gender:"+gender, Toast.LENGTH_SHORT).show();
        myRef.child("SignUp").setValue(savedata);


    }
}