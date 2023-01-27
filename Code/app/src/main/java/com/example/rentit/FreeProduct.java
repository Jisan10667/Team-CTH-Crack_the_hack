package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class FreeProduct extends AppCompatActivity {

    // buttons
    Button give;
    Button take;

    // login track
    String emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        // hide the title bar

        // login info passing
        Intent intents = getIntent();
        emails = intents.getStringExtra("emails");
        // login info passing

        setContentView(R.layout.activity_free_product);

        give = findViewById(R.id.free_give);
        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeProduct.this , FreeGive.class);
                // pass login data
                intent.putExtra("emails" ,emails);
                // pass login data
                startActivity(intent);

            }
        });

        take = findViewById(R.id.Free_take);
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeProduct.this , FreeTake.class);
                // pass login data
                intent.putExtra("emails" ,emails);
                // pass login data
                startActivity(intent);

            }
        });
    }

    public void onBackPressed() {

        Intent intent = new Intent(FreeProduct.this, Menu.class);
        // pass login data to menu
        intent.putExtra("emails", emails);
        // pass login data to menu
        startActivity(intent); // go to menu screen

        super.onBackPressed();
    }
}