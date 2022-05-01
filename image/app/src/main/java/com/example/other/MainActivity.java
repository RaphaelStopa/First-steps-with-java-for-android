package com.example.other;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Switch imageSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitch = findViewById(R.id.switch1);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.estampa_imfine);

        imageSwitch.setChecked(true);
        imageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
//                    imageView.setImageResource(R.drawable.estampa_imfine);
                    imageView.setImageDrawable(getImageDrawable("estampa_imfine"));
                }else{
                    imageView.setImageDrawable(getImageDrawable("nha"));
//                    imageView.setImageResource(R.drawable.nha);
                }
            }
        });
    }
    protected Drawable getImageDrawable(String name) {
        return getResources().getDrawable(
                getResources().getIdentifier(name, "drawable", getPackageName()), getTheme()
        );
    }
}