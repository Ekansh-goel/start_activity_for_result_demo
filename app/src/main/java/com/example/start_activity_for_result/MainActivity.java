package com.example.start_activity_for_result;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt_one;
    private Button btn_one;
    private TextView txt_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_one = findViewById(R.id.edt_one);
        txt_one = findViewById(R.id.txt_one);
        btn_one = findViewById(R.id.btn_one);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data_one = edt_one.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, second_activity.class);
                intent.putExtra("data_one", data_one);
                startActivityForResult(intent, 999);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(RESULT_OK, 999, data);

        String second = data.getExtras().getString("data_2");
        txt_one.setText(second);
        Toast.makeText(this, "data received form activity two", Toast.LENGTH_SHORT).show();

    }
}
