package com.zitafutemain.andeleproject.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zitafutemain.andeleproject.databinding.SplashScreenBinding;

import java.util.Timer;

public class SplashScreen extends AppCompatActivity {
    private SplashScreenBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=SplashScreenBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        startDashboardActivity();
    }

    private void startDashboardActivity(){
        final Timer t = new Timer();
        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intent);
                        t.cancel();
                    }
                },
                400
        );
    }
}
