package com.example.suncuoglu.handlerexample;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.suncuoglu.handlerexample.Adaptor.CustomAdapterPager;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TextView text;
    private ViewPager viewPager;
    private ArrayList<Image> images = new ArrayList<>();
    private MyFragment myFragment;
    String name;


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        viewPager = findViewById(R.id.viewPager);

        final CustomAdapterPager adapter = new CustomAdapterPager(images, this);
        adapter.AddItem(new Image("https://i1.imgiz.com/rshots/8951/resimler-cizelim-balik-cocuklar-icin-egitici-cizgi-film_8951611-3744_1800x945.jpg"));
        adapter.AddItem(new Image("http://espassanat.com/wp-content/uploads/2016/07/resim-kursu-bal%C3%A7ova.jpg"));
        adapter.AddItem(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT35sWxJK54fFnmcKJYWyqmB7fnzP-cqGM5uV-dTgLvt6UL4kFt"));
        viewPager.setAdapter(adapter);

        new CountDownTimer(1000000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("seconds remaining: " + millisUntilFinished / 1000);
                if(millisUntilFinished<=998000){
                if (viewPager.getCurrentItem() != 0 && viewPager.getCurrentItem() % (images.size()-1) == 0) {
                    viewPager.setCurrentItem(0, true);
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
                }
            }

            public void onFinish() {
                text.setText("done!");
            }
        }.start();

        //ex
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addFragment(name);
            }
        }, 3000);
    }

    public void addFragment(String name) {
        myFragment = MyFragment.newInstance(name);
        myFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout, myFragment).commit();
    }
}
