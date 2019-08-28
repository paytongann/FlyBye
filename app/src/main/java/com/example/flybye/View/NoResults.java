package com.example.flybye.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.flybye.R;

public class NoResults extends AppCompatActivity {

    Button btnSearchAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_results);
        btnSearchAgain = findViewById(R.id.btn_search_again);
        btnSearchAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoResults.this, SelectWayActivity.class);
                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });
    }
}
