package com.gferl.todoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class OnBoarding extends AppCompatActivity {

    private ViewPager viewPager;
    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        makeStatusbarTransparent();

        viewPager = findViewById(R.id.onboarding_view_pager);

        onboardingAdapter = new OnboardingAdapter(this);
        viewPager.setAdapter(onboardingAdapter);
        viewPager.setPageTransformer(false, new OnboardingPageTransformer());


    }


    // Listener for next button press
    public void nextPage(View view) {
        if (view.getId() == R.id.button2) {
            if (viewPager.getCurrentItem() < onboardingAdapter.getCount() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        }
    }

    private void makeStatusbarTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}