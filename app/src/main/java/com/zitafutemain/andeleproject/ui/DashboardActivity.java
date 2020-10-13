package com.zitafutemain.andeleproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.zitafutemain.andeleproject.Adapter.CustomViewPagerAdapter;
import com.zitafutemain.andeleproject.R;

public class DashboardActivity extends AppCompatActivity {
    private MaterialToolbar toolbar;
    private Button submitButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboad_activity);
        setUpViewPager();
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        submitButton=(Button) findViewById(R.id.submitButton);
        setToolbar();
        submitButton.setOnClickListener(view -> {
            Intent intent = new Intent(this,FormSubmit.class);
            startActivity(intent);
        });
    }
    private void setToolbar() {
        toolbar.setTitle(R.string.leaderboard);
        setSupportActionBar(toolbar);
    }
    private  void setUpViewPager(){
        ViewPager viewPager=findViewById(R.id.pager);
        viewPager.setAdapter(new CustomViewPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
