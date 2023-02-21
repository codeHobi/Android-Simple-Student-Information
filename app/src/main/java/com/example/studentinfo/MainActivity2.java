package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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

        classPart = (EditText) findViewById(R.id.etClasspart);
        quiz = (EditText) findViewById(R.id.etQuiz);
        perfTask = (EditText) findViewById(R.id.etTaskperf);
        exam =(EditText) findViewById(R.id.etExam);
        equiv = (TextView) findViewById(R.id.tvEquivalent);

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
        equiv.addTextChangedListener(computeTW);
    }

    private TextWatcher computeTW = new TextWatcher() {
        //Double classpnum = Double.parseDouble(classpartInput);
        //Double quiznum = Double.parseDouble(quizInput);
        //Double tasknum = Double.parseDouble(perftaskInput);
        //Double examnum = Double.parseDouble(examInput);

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String classpartInput = classPart.getText().toString().trim();
            String quizInput = quiz.getText().toString().trim();
            String perftaskInput = perfTask.getText().toString().trim();
            String examInput = exam.getText().toString().trim();

            viewDialog.setEnabled(!classpartInput.isEmpty() && !quizInput.isEmpty()
                    && !perftaskInput.isEmpty() && !examInput.isEmpty());
            cancel.setEnabled(!classpartInput.isEmpty() || !quizInput.isEmpty()
                    || !perftaskInput.isEmpty() || !examInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {
            //Double equinum = ((classpnum * 0.1) + (quiznum * 0.2) + (tasknum * 0.3) + (examnum * 0.4)) / 4;
            //String finalequiv = equinum.toString();

            //equiv.setText(String.format("%.2f", equinum));
        }
    };
}