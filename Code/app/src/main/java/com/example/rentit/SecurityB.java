package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class SecurityB extends AppCompatActivity {

    MaterialButton deposit;
    MaterialButton verify;

    // data passing
    String emails;
    // data passing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        // hide the title bar

        setContentView(R.layout.activity_security_b);


        // login info passing
        Intent intents = getIntent();
        emails = intents.getStringExtra("emails");
        // login info passing

        deposit = findViewById(R.id.deposit);
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecurityB.this , DeliveryB.class );
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });

        verify = findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecurityB.this , DeliveryB.class );
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });
    }


    public void onBackPressed() {

        Intent intent = new Intent(SecurityB.this, OrderBuy.class);
        // pass login data to menu
        intent.putExtra("emails", emails);
        // pass login data to menu
        startActivity(intent); // go to sell screen

        super.onBackPressed();
    }
}