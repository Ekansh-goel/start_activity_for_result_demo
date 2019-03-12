package com.example.start_activity_for_result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class second_activity extends AppCompatActivity {
    private EditText edt_two;
    private Button btn_two;
    private TextView txt_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        edt_two = findViewById(R.id.edt_two);
        btn_two = findViewById(R.id.btn_two);
        txt_two = findViewById(R.id.txt_two);
        Bundle bundle = getIntent().getExtras();
        String second = bundle.getString("data_one");
        txt_two.setText(second);

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second_activity.this, "data received form activity one", Toast.LENGTH_SHORT).show();
                String name2 = edt_two.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("data_2", name2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
