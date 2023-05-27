package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private int[] imageIds = {R.drawable.images2, R.drawable.images3, R.drawable.images4, R.drawable.images44};

    ImageView snap, twitter, pin, amazon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.grid);

        snap = findViewById(R.id.snap);
        twitter = findViewById(R.id.twitter);
        pin = findViewById(R.id.pin);
        amazon = findViewById(R.id.amazon);


        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View view = gridLayout.getChildAt(i);

            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                imageView.setImageResource(imageIds[i]);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snap.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                gotoUrl("https://accounts.snapchat.com/accounts/v2/login");

                            }

                        });

                        twitter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                gotoUrl("https://twitter.com/i/flow/login");

                            }
                        });
                        pin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                gotoUrl("https://in.pinterest.com/login/");

                            }
                        });

                        amazon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                gotoUrl("https://www.amazon.in/your-account");

                            }
                        });
                    }
                });
            }

        }
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}