package com.example.museums;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Museum2 extends AppCompatActivity {
    private final Integer[] images ={R.drawable.mos_museum1,R.drawable.mos_museum2,R.drawable.mos_museum3,R.drawable.mos_museum4,R.drawable.mos_museum5,R.drawable.mos_museum6,R.drawable.mos_museum7,R.drawable.mos_museum8,R.drawable.mos_museum9,R.drawable.mos_museum10};
    private int currImage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum2);
        setInitialImage();
        setImageRotateListener();
    }
    private void setImageRotateListener() {
        final Button rotateForward = (Button) findViewById(R.id.btnRotateForwards2);
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
        final Button rotateBackward = (Button) findViewById(R.id.btnRotateBackwards2);
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
        String[] description = getResources().getStringArray(R.array.MosMuseumImages);
        final TextView textView =(TextView) findViewById(R.id.description);
        textView.setText(String.format("%s", description[currImage]));
    }
    private void setCurrentTitle(){
        String[] title = getResources().getStringArray(R.array.MosMuseumNames);
        final TextView textView =(TextView) findViewById(R.id.mosmuseumTitle);
        textView.setText(String.format("%s", title[currImage]));
    }
}