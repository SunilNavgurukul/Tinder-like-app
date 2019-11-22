package com.example.konnectorapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusbar));
        setContentView(R.layout.activity_main);

        BottomNavigationView navi = findViewById(R.id.navigation_bottom);
        navi.setOnNavigationItemSelectedListener(navigalis);
        ImageButton imageButton = findViewById(R.id.swipe_filter);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frament, new swipeActivity())
                .commit();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigalis =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = new swipeActivity();

                    switch (menuItem.getItemId()){
                        case R.id.card:
                            selectedFragment = new swipeActivity();
                            break;
                        case R.id.navigation:
                            selectedFragment = new SwipeFragemnt();
                            break;
                        case R.id.massege:
                            selectedFragment = new SwipeFragemnt();
                            break;
                        case R.id.navigation_profile:
                            selectedFragment = new SwipeFragemnt();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frament,
                            selectedFragment).commit();

                    return true;
                }
            };

}
