package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView taimer;
    TextView primer;
    TextView results;

    TextView answer1;
    TextView answer2;
    TextView answer3;
    TextView answer4;

    TextView finalRes;

    Button  go;

    CountDownTimer vremia;

    int hod = 0;
    int success = 0;

    int x;
    int y;
    int z;

    int gameOnOff = 0;

    public void visInvis(){
        if (gameOnOff == 0) {
            taimer.setVisibility(View.VISIBLE);
            primer.setVisibility(View.VISIBLE);
            results.setVisibility(View.VISIBLE);
            answer1.setVisibility(View.VISIBLE);
            answer2.setVisibility(View.VISIBLE);
            answer3.setVisibility(View.VISIBLE);
            answer4.setVisibility(View.VISIBLE);
            finalRes.setVisibility(View.INVISIBLE);
            go.setVisibility(View.INVISIBLE);
        } else if (gameOnOff==1){

            go.setText("New game");
            go.setVisibility(View.VISIBLE);
            finalRes.setVisibility(View.VISIBLE);
            finalRes.setText(success + " correct answers from " + hod);

            hod = 0;
            success = 0;
            gameOnOff = 0;

        }
    }

    public void sample(){
        x = (int) (Math.random() * 99);
        y = (int) (Math.random() * 99);
        z = x + y;
        primer.setText(x + " + " + y);
    }

    public void variants(){
        int asn = (int) (Math.random() * 40);

        if(asn <= 10) {
            answer1.setText(String.valueOf(z));
            answer2.setText(String.valueOf (z-1));
            answer3.setText(String.valueOf (z+5));
            answer4.setText(String.valueOf (z-5));
        }

        if((asn > 10) & (asn <= 20)) {
            answer1.setText(String.valueOf (z -1 ));
            answer2.setText(String.valueOf(z));
            answer3.setText(String.valueOf (z+5));
            answer4.setText(String.valueOf (z- 5));
        }

        if((asn > 20) & (asn <= 30)){
            answer1.setText(String.valueOf (z-1));
            answer2.setText(String.valueOf (z+5));
            answer3.setText(String.valueOf(z));
            answer4.setText(String.valueOf (z-5));
        }

        if((asn > 30) & (asn <= 41)){
            answer1.setText(String.valueOf (z-1));
            answer2.setText(String.valueOf (z+5));
            answer3.setText(String.valueOf (z-5));
            answer4.setText(String.valueOf(z));
        }
    }

    public void chooseAns(View view){
        TextView text = (TextView) view;
        if(String.valueOf(z).equals(text.getText().toString())){
           success = success + 1;
        }
        sample();
        variants();
        hod = hod + 1;
        results.setText(success + "/" + hod);
    }

    public void startGame(View view) {
        visInvis();
         vremia = new CountDownTimer(30000, 1000) {
             @Override
             public void onTick(long millisecondsUntilDone) {
                taimer.setText("0" +":" + millisecondsUntilDone/ 1000);
             }
             @Override
             public void onFinish() {
                 gameOnOff = 1;
                 visInvis();
             }
         }.start();
         sample();
         variants();
         results.setText(success + "/" + hod);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taimer = (TextView) findViewById(R.id.taimer);
        primer = (TextView) findViewById(R.id.primer);
        results = (TextView) findViewById(R.id.results);

        answer1 = (TextView) findViewById(R.id.answer1);
        answer2 = (TextView) findViewById(R.id.answer2);
        answer3 = (TextView) findViewById(R.id.answer3);
        answer4 = (TextView) findViewById(R.id.answer4);

        finalRes =(TextView)  findViewById(R.id.finalMessage);

        go = (Button) findViewById(R.id.go);
    }
}