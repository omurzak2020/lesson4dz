package com.example.lesson4dz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class SecondActivity extends AppCompatActivity {

    public static final String URI_IMAGE = "stiringUri";
    public static final String TEXTT = "stiringUri2";
    private ImageView imageView;
    private EditText editText;
    private Button button;
    Uri uri;
    String input;
    String image;


    private static final int SELECT_IMAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
        intents();
    }

    private void init() {

        imageView = findViewById(R.id.imageView2d);
        editText = findViewById(R.id.EditView2b);
        button = findViewById(R.id.botton2d);
        input = editText.getText().toString();


    }

    public void imageView2d(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && data != null){
            uri = data.getData();
            imageView.setImageURI(uri);
            image=data.getDataString();
        }
    }

    private  void intents(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(URI_IMAGE,image);
                intent.putExtra(TEXTT,input);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}