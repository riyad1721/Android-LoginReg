package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fingerprint extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private FingerprintManager fingerprintManager;
    private FingerprintManager.AuthenticationCallback authenticationCallback;
    private Button ExitBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.fingerprin);
        ExitBttn=findViewById(R.id.btnExit);

        fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
        authenticationCallback = new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                textView.setText("ERROR");
                imageView.setImageResource(R.drawable.submifinger);
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                textView.setText("সাহায্য নিন");
                imageView.setImageResource(R.drawable.submifinger);
                super.onAuthenticationHelp(helpCode, helpString);
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                textView.setText("আপনার ভোট টি সম্পন্ন হইছে");
                ExitBttn.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.submifinger);
                super.onAuthenticationSucceeded(result);

            }

            @Override
            public void onAuthenticationFailed() {
                textView.setText("পুনরায় চেষ্টা করুন");
                imageView.setImageResource(R.drawable.submifinger);
                super.onAuthenticationFailed();
            }
        };
       ExitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void scanButton(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            fingerprintManager.authenticate(null, null, 0, authenticationCallback, null);
        }
    }
}