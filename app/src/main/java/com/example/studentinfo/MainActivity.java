package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText studNum, lastName, firstName, middleInitial, classSection;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studNum = (EditText)findViewById(R.id.etStudNum);
        lastName = (EditText)findViewById(R.id.etLname);
        firstName = (EditText)findViewById(R.id.etFname);
        middleInitial = (EditText)findViewById(R.id.etMi);
        classSection = (EditText)findViewById(R.id.etClassSec);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(studNum.getText())) {
                    studNum.setError("Student number is required!");
                } else if (TextUtils.isEmpty(lastName.getText())) {
                    lastName.setError("Last name is required!");
                } else if (TextUtils.isEmpty(firstName.getText())) {
                    firstName.setError("First name is required!");
                } else if (TextUtils.isEmpty(middleInitial.getText())) {
                    middleInitial.setError("Middle initial is required!");
                } else if (TextUtils.isEmpty(classSection.getText())) {
                    classSection.setError("Class section is required!");
                } else {
                    Toast.makeText(MainActivity.this, "Student Info Saved", Toast.LENGTH_SHORT).show();
                    Intent act2 = new Intent(MainActivity.this,MainActivity2.class);

                    act2.putExtra("STUDENTNUM", studNum.getText().toString());
                    act2.putExtra("LASTNAME", lastName.getText().toString());
                    act2.putExtra("FIRSTNAME", firstName.getText().toString());
                    act2.putExtra("MIDDLEINITIAL", middleInitial.getText().toString());
                    act2.putExtra("SECTION", classSection.getText().toString());

                    startActivity(act2);
                }
            }
        });
    }
}