package com.example.studentinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView showStudnum, showStudname, showStudsection, equiv;
    EditText classPart, quiz, perfTask, exam;
    Button viewDialog, cancel;
    Double cpartValue, quizValue, ptaskValue, examValue, result, note;
    String remarks="";

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

        viewDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                note = Double.parseDouble(equiv.getText().toString());
                String ave = equiv.getText().toString();

                //CONDITION FOR REMARKS
                if (note > 74.4) {
                    remarks = "PASSED";
                }else {
                    remarks = "FAILED";
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Student Grade");
                alert.setMessage("Student Number: " + sNum +
                        "\nStudent Name: " + lName + ", " + fName + " " + mInitial + ". " +
                        "\nStudent Section: " + sec +
                        "\n\nAverage: " + ave + "\nRemarks: " + remarks);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classPart.setText("");
                quiz.setText("");
                perfTask.setText("");
                exam.setText("");
                equiv.setText("");
                Toast.makeText(MainActivity2.this, "Grades Cleared", Toast.LENGTH_SHORT).show();

                viewDialog.setEnabled(false);
                cancel.setEnabled(false);
            }
        });
    }

    private TextWatcher computeTW = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if (!TextUtils.isEmpty(classPart.getText().toString())
                        || !TextUtils.isEmpty(quiz.getText().toString())
                        || !TextUtils.isEmpty(perfTask.getText().toString())
                        || !TextUtils.isEmpty(exam.getText().toString())
                ) {
                    cpartValue = Double.parseDouble(classPart.getText().toString());
                    quizValue = Double.parseDouble(quiz.getText().toString());
                    ptaskValue = Double.parseDouble(perfTask.getText().toString());
                    examValue = Double.parseDouble(exam.getText().toString());

                    result = (cpartValue * 0.1) + (quizValue * 0.2) + (ptaskValue * 0.3) + (examValue * 0.4);
                    equiv.setText(String.format("%.2f", result));
                }else {
                    equiv.setText("");
                }
            } catch (Exception e) {

            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(classPart.getText().toString())
                    && !TextUtils.isEmpty(quiz.getText().toString())
                    && !TextUtils.isEmpty(perfTask.getText().toString())
                    && !TextUtils.isEmpty(exam.getText().toString())
            ) {
                viewDialog.setEnabled(true);
                cancel.setEnabled(true);
            } else if (TextUtils.isEmpty(classPart.getText().toString())
                    || TextUtils.isEmpty(quiz.getText().toString())
                    || TextUtils.isEmpty(perfTask.getText().toString())
                    || TextUtils.isEmpty(exam.getText().toString())
            ) {
                viewDialog.setEnabled(false);
            } else {

            }
        }
    };

}