package com.example.lesson4dz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private Button button, button2;
    private TextView textView;
    private ImageView imageView;
    String gotImage;
    String gotText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        getInfo();
    }

    private void init() {
        button = findViewById(R.id.botton1);
        button2 = findViewById(R.id.botton2);
        textView = findViewById(R.id.textView1);
        imageView = findViewById(R.id.imageView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void getInfo() {
        Intent intent = getIntent();
        gotImage = intent.getStringExtra(SecondActivity.URI_IMAGE);
        gotText = intent.getStringExtra(SecondActivity.TEXTT);
        if (intent.getStringExtra(SecondActivity.TEXTT) != null && intent.getStringExtra(SecondActivity.URI_IMAGE) != null) {
            textView.setText(gotText);
            imageView.setImageURI(Uri.parse(gotImage));
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            textView.setText(data.getStringExtra(SecondActivity.TEXTT));
            Uri uri = Uri.parse(data.getStringExtra(SecondActivity.URI_IMAGE));
            imageView.setImageURI(uri);

        }
    }
}