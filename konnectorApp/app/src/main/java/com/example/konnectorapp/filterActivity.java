package com.example.konnectorapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;

import info.hoang8f.android.segmented.SegmentedGroup;

//import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class filterActivity extends AppCompatActivity {

    private TextView textView, righttextView, lefttextView;
    private SeekBar seekBar1;
    private Button backbutton;

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusbar));

        setContentView(R.layout.filterlayout);
        SegmentedGroup segmented2 = (SegmentedGroup) findViewById(R.id.segmented2);
        segmented2.setTintColor(this.getResources().getColor(R.color.text_gray));
        backbutton = (Button) findViewById(R.id.back_button);

        textView = findViewById(R.id.progress_per);
        righttextView = findViewById(R.id.textView7);
        lefttextView = findViewById(R.id.textView8);
        seekBar1 = findViewById(R.id.progress_sek);
        CrystalRangeSeekbar seekBar2 = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar4);


        seekBar2.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                righttextView.setText(String.valueOf(minValue));
                lefttextView.setText(String.valueOf(maxValue));
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });


//        seekBar2.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
//            @Override
//            public void onRangeSeekBarValuesChanged(Integer minValue, Integer maxValue) {
//                //Now you have the minValue and maxValue of your RangeSeekbar
//                lefttextView.setText(String.valueOf(maxValue));
//                righttextView.setText(String.valueOf(minValue));
//            }
//        });

// Get noticed while dragging
//        seekBar2.setNotifyWhileDragging(true);
//        seekBar2.setColorFilter(R.color.colorAccent);





        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("" + progress + "km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
