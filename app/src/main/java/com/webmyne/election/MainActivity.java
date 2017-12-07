package com.webmyne.election;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Button btnDemo1;
    private Button btnDemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        actionListener();
    }

    private void actionListener() {
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Demo1Activity.class);
                startActivity(intent);
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Demo2Activity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        btnDemo1 = (Button) findViewById(R.id.btnDemo1);
        btnDemo2 = (Button) findViewById(R.id.btnDemo2);
    }


}
