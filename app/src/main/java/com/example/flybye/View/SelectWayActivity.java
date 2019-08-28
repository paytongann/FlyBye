package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.flybye.R;

public class SelectWayActivity extends AppCompatActivity {

    RelativeLayout oneWay, roundTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_way);

        oneWay = findViewById(R.id.select_oneway);
        roundTrip = findViewById(R.id.select_roundtrip);

        oneWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectWayActivity.this, SearchFlightsActivity.class);
                intent.putExtra("way", "oneway");
                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });

        roundTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectWayActivity.this, SearchFlightsActivity.class);
                intent.putExtra("way", "roundtrip");
                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });
    }
}
