package com.walkud.rom.checker.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.RomIdentifier;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.rom_info_tv);
    }

    public void checkRom(View view) {
        Rom rom = RomIdentifier.getRom();
        textView.setText("Rom：" + rom.toString());
        Log.d("AndroidRomChecker", "Rom：" + rom.toString());
    }
}
