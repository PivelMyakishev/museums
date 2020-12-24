package com.example.museums;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Museum1 extends AppCompatActivity {
    private final Integer[] images ={R.drawable.tretyakovka_picture1,R.drawable.tretyakovka_picture2,R.drawable.tretyakovka_picture3,R.drawable.tretyakovka_picture4,R.drawable.tretyakovka_picture5,R.drawable.tretyakovka_picture6,R.drawable.tretyakovka_picture7,R.drawable.tretyakovka_picture8,R.drawable.tretyakovka_picture9,R.drawable.tretyakovka_picture10,};
    private int currImage =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum1);

        setInitialImage();
        setImageRotateListener();
    }
    private void setImageRotateListener() {
        final Button rotateForward = (Button) findViewById(R.id.btnRotateForwards);
        rotateForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currImage++;


                if (currImage == images.length) {
                    currImage = 0;

                }
                setCurrentImage();
                setCurrentText();
                setCurrentTitle();
            }
        });
        final Button rotateBackward = (Button) findViewById(R.id.btnRotateBackwards);
        rotateBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currImage== 0){
                    currImage = images.length;
                }
                currImage--;
                setCurrentImage();
                setCurrentText();
                setCurrentTitle();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
        setCurrentText();
        setCurrentTitle();
    }


    private void setCurrentImage() {

        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        imageView.setImageResource(images[currImage]);

    }
    private void setCurrentText(){
        String[] description = getResources().getStringArray(R.array.TretyakovImages);
        final TextView textView =(TextView) findViewById(R.id.description);
        textView.setText(String.format("%s", description[currImage]));
    }
    private void setCurrentTitle(){
        String[] title = getResources().getStringArray(R.array.TretyakovNames);
        final TextView textView =(TextView) findViewById(R.id.tretykakovTitle);
        textView.setText(String.format("%s", title[currImage]));
    }
}