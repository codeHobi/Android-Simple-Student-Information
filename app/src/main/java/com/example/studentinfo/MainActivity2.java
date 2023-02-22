package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView showStudnum, showStudname, showStudsection;
    EditText classPart;
    EditText quiz;
    EditText perfTask;
    EditText exam;
    TextView equiv;
    Button viewDialog, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showStudnum = (TextView) findViewById(R.id.tvStudnum);
        showStudname = (TextView) findViewById(R.id.tvStudname);
        showStudsection = (TextView) findViewById(R.id.tvSection);
        equiv = (TextView) findViewById(R.id.tvEquivalent);

        classPart = (EditText) findViewById(R.id.etClasspart);
        quiz = (EditText) findViewById(R.id.etQuiz);
        perfTask = (EditText) findViewById(R.id.etTaskperf);
        exam =(EditText) findViewById(R.id.etExam);

        viewDialog = (Button) findViewById(R.id.btnView);
        cancel = (Button) findViewById(R.id.btnCancel);

        Intent act2 = getIntent();
        String sNum = act2.getStringExtra("STUDENTNUM");
        String lName = act2.getStringExtra("LASTNAME");
        String fName = act2.getStringExtra("FIRSTNAME");
        String mInitial = act2.getStringExtra("MIDDLEINITIAL");
        String sec = act2.getStringExtra("SECTION");

        showStudnum.setText(sNum);
        showStudname.setText(lName + ", " + fName + " " + mInitial + ". ");
        showStudsection.setText(sec);

        classPart.addTextChangedListener(computeTW);
        quiz.addTextChangedListener(computeTW);
        perfTask.addTextChangedListener(computeTW);
        exam.addTextChangedListener(computeTW);
        //equiv.addTextChangedListener(computeTW);
    }

    private TextWatcher computeTW = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if (!TextUtils.isEmpty(classPart.getText().toString().trim())
                        || !TextUtils.isEmpty(quiz.getText().toString().trim())
                        || !TextUtils.isEmpty(perfTask.getText().toString().trim())
                        || !TextUtils.isEmpty(exam.getText().toString().trim())
                ) {
                    Double cpartValue = Double.parseDouble(classPart.getText().toString().trim());
                    Double quizValue = Double.parseDouble(quiz.getText().toString().trim());
                    Double ptaskValue = Double.parseDouble(perfTask.getText().toString().trim());
                    Double examValue = Double.parseDouble(exam.getText().toString().trim());

                    double result = (cpartValue * 0.1) + (quizValue * 0.2) + (ptaskValue * 0.3) + (examValue * 0.4);
                    equiv.setText(String.valueOf(String.format("%.2f", result)));
                    viewDialog.setEnabled(true);
                    cancel.setEnabled(true);
                }else {
                    equiv.setText("");
                }
            } catch (NumberFormatException e) {

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}