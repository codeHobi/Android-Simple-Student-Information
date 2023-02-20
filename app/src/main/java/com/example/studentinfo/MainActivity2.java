package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView showStudnum, showStudname, showStudsection;
    EditText classPart, quiz, perfTask, exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showStudnum = (TextView) findViewById(R.id.tvStudnum);
        showStudname = (TextView) findViewById(R.id.tvStudname);
        showStudsection = (TextView) findViewById(R.id.tvSection);

        classPart = (EditText) findViewById(R.id.etClasspart);
        quiz = (EditText) findViewById(R.id.etQuiz);
        perfTask = (EditText) findViewById(R.id.etTaskperf);
        exam =(EditText) findViewById(R.id.etExam);

        Intent act2 = getIntent();
        String sNum = act2.getStringExtra("STUDENTNUM");
        String lName = act2.getStringExtra("LASTNAME");
        String fName = act2.getStringExtra("FIRSTNAME");
        String mInitial = act2.getStringExtra("MIDDLEINITIAL");
        String sec = act2.getStringExtra("SECTION");

        showStudnum.setText(sNum);
        showStudname.setText(lName + ", " + fName + " " + mInitial + ". ");
        showStudsection.setText(sec);
    }
}