package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderBuy extends AppCompatActivity {

    String emails;
    String name , description , rating , price , image;

    EditText n , d , r , p;
    ImageView i;
    Button cancel , next;

    FirebaseFirestore firebaseFirestore;

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
        name  = intents.getStringExtra("name");
        description = intents.getStringExtra("description");
        rating = intents.getStringExtra("rating");
        price  = intents.getStringExtra("price");
        image = intents.getStringExtra("image");
        // login info passing

        setContentView(R.layout.activity_order_buy);

        i = findViewById(R.id.p_image);
        Glide.with(OrderBuy.this).load(image).into(i);

        n = findViewById(R.id.p_name);
        d = findViewById(R.id.p_des);
        p = findViewById((R.id.p_price));
        r = findViewById(R.id.p_rating);
        n.setText(name);
        d.setText(description);
        p.setText(price);
        r.setText(rating);
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrderBuy.this , RentTake.class);
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        next = findViewById(R.id.confirm);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // adding to database
                Map<String,String > items = new HashMap<>();
                items.put("name", name);
                items.put("description", description);
                items.put("rating", rating);
                items.put("address",price);
                items.put("image",image);
                items.put("type","Paid");
                items.put("head","Bought By You");

                firebaseFirestore.collection(emails).add(items);

                // adding to database

                Intent intent = new Intent(OrderBuy.this , SecurityB.class);
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });





    }

    public void onBackPressed() {

        Intent intent = new Intent(OrderBuy.this, RentTake.class);
        // pass login data to menu
        intent.putExtra("emails", emails);
        // pass login data to menu
        startActivity(intent); // go to sell screen

        super.onBackPressed();
    }
}