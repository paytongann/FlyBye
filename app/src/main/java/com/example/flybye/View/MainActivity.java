package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.flybye.R;

public class MainActivity extends AppCompatActivity {

    Button btnSearchFlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearchFlights = findViewById(R.id.btn_search_flights);
        btnSearchFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchFlightsActivity.class);
                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });
    }
}
