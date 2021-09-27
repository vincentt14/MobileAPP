package id.ac.umn.week04b_37401;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button halaman1, halaman2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        halaman1 = findViewById(R.id.main_button_change_1);
        halaman2 = findViewById(R.id.main_button_change_2);

        halaman1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent halamanSatu = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(halamanSatu);
            }
        });

        halaman2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent halamanDua = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(halamanDua);
            }
        });
    }
}