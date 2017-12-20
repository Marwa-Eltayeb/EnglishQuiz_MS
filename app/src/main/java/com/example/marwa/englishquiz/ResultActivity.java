package com.example.marwa.englishquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ResultActivity extends AppCompatActivity {

    TextView nameTextView;
    ImageView resultImageView;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        int result = intent.getIntExtra(MainActivity.RESULT,0);
        String fullResult = result + getResources().getString(R.string.percentage);

        nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText(name);

        resultTextView = (TextView) findViewById(R.id.result);
        resultImageView = (ImageView) findViewById(R.id.image);


        // Feedback for the Result
        if (result >= 80) {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.happy);
            Toast.makeText(this, "Well Done!", Toast.LENGTH_SHORT).show();


        }else if (result > 0){
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.fair);
            Toast.makeText(this, "Fair", Toast.LENGTH_SHORT).show();
        }else {
            resultTextView.setText(fullResult);
            resultImageView.setImageResource(R.drawable.sad);
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }




    }
}
