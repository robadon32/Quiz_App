package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreOne; int scoreTwo; int scoreThree; int scoreFour; int scoreFive; int scoreSix;
    int scoreSeven; int scoreEight; int scoreNine; int scoreTen; int total = 10; int endResult;

    EditText editText; CheckBox checkBox1; CheckBox checkBox2; CheckBox checkBox3; CheckBox checkBox4;
    CheckBox checkBox5; CheckBox checkBox6; RadioGroup groupOne; RadioGroup groupTwo; RadioGroup groupThree;
    RadioGroup groupFour; RadioGroup groupFive; RadioGroup groupSix; RadioGroup groupSeven;
    RadioGroup groupNine;

    /*
    Finds the view and stores the ID value in a variable
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.name_field);

        checkBox1 = findViewById(R.id.checkbox101); checkBox2 = findViewById(R.id.checkbox102);
        checkBox3 = findViewById(R.id.checkbox103); checkBox4 = findViewById(R.id.checkbox104);
        checkBox5 = findViewById(R.id.checkbox105); checkBox6 = findViewById(R.id.checkbox106);

        groupOne = findViewById(R.id.group_one); groupTwo = findViewById(R.id.group_two);
        groupThree = findViewById(R.id.group_three); groupFour = findViewById(R.id.group_four);
        groupFive = findViewById(R.id.group_five); groupSix = findViewById(R.id.group_six);
        groupSeven = findViewById(R.id.group_seven); groupNine = findViewById(R.id.group_nine);
    }

    /*
    Method to add the points you received for each question and Returns the results.
     */
    public int calculateResults (){

        scoreOne = questionOne(); scoreTwo = questionTwo(); scoreThree = questionThree();
        scoreFour = questionFour(); scoreFive = questionFive(); scoreSix = questionSix();
        scoreSeven = questionSeven(); scoreEight = questionEight(); scoreNine = questionNine();
        scoreTen = questionTen();

        return endResult = scoreOne + scoreTwo + scoreThree + scoreFour + scoreFive + scoreSix
                + scoreSeven + scoreEight + scoreNine + scoreTen;
    }

    /*
    Method to submit your answers ONLY if you answered ALL the questions AND put your name.
     */
    public void submit(View view){

        int g1 = groupOne.getCheckedRadioButtonId(); int g2 = groupTwo.getCheckedRadioButtonId();
        int g3 = groupThree.getCheckedRadioButtonId(); int g4 = groupFour.getCheckedRadioButtonId();
        int g5 = groupFive.getCheckedRadioButtonId(); int g6 = groupSix.getCheckedRadioButtonId();
        int g7= groupSeven.getCheckedRadioButtonId(); int g9 = groupNine.getCheckedRadioButtonId();

        EditText questionEight = findViewById(R.id.name_field2);
        String g8 = questionEight.getText().toString();


        boolean state1 = checkBox1.isChecked(); boolean state2 = checkBox2.isChecked();
        boolean state3 = checkBox3.isChecked(); boolean state4 = checkBox4.isChecked();
        boolean state5 = checkBox5.isChecked(); boolean state6 = checkBox6.isChecked();

        String nameField = editText.getText().toString();

        if (nameField.matches("")) {
            Toast toast = Toast.makeText(this, "Please enter your name before submitting",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        else if (g1 == -1 || g2 == -1 || g3 == -1 || g4 == -1 || g5 == -1 || g6 == -1 || g7 == -1 || g9 == -1
                || g8.isEmpty() || !state1 & !state2 & !state3 & !state4 & !state5 & !state6) {
            Toast toast = Toast.makeText(this, "Please answer all questions before submitting",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else
            displayResultMessage();
    }

    /*
    Method to display a TOAST message with your results AFTER submission.
     */
    public void displayResultMessage() {

        int result = calculateResults();

         if (result <= 3){
            Toast toast = Toast.makeText(this, "You got " + result + "/" + total + " " +
                    "You are a BANDWAGON fan! You might not want to email these result yikes!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        else if (result >= 4 & result <=6){
            Toast toast = Toast.makeText(this, "You got " + result + "/" + total +
                    " You need to study a little more! Email your results.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        else if (result >=7 & result <=9){
            Toast toast = Toast.makeText(this, "You got " + result + "/" + total +
                    " You are a Fan! Email your results.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else if (result == 10){
            Toast toast = Toast.makeText(this, "You got " + result + "/" + total +
                    " You are a FANATIC! Email your results.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }

    /*
    Method to share your results by email.
     */
    public void email(View view){

        int result = calculateResults();
        Intent intent = new Intent(Intent.ACTION_SEND);

        int g1 = groupOne.getCheckedRadioButtonId(); int g2 = groupTwo.getCheckedRadioButtonId();
        int g3 = groupThree.getCheckedRadioButtonId(); int g4 = groupFour.getCheckedRadioButtonId();
        int g5 = groupFive.getCheckedRadioButtonId(); int g6 = groupSix.getCheckedRadioButtonId();
        int g7= groupSeven.getCheckedRadioButtonId(); int g9 = groupNine.getCheckedRadioButtonId();

        EditText questionEight = findViewById(R.id.name_field2);
        String g8 = questionEight.getText().toString();

        EditText nameField1 = findViewById(R.id.name_field);
        String name = nameField1.getText().toString();

        boolean state1 = checkBox1.isChecked(); boolean state2 = checkBox2.isChecked();
        boolean state3 = checkBox3.isChecked(); boolean state4 = checkBox4.isChecked();
        boolean state5 = checkBox5.isChecked(); boolean state6 = checkBox6.isChecked();

        String nameField = editText.getText().toString();

        if (nameField.matches("")) {
            Toast toast = Toast.makeText(this, "Please enter your name before emailing results",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        else if (g1 == -1 || g2 == -1 || g3 == -1 || g4 == -1 || g5 == -1 || g6 == -1 || g7 == -1 || g9 == -1
                || g8.isEmpty() || !state1 & !state2 & !state3 & !state4 & !state5 & !state6) {
            Toast toast = Toast.makeText(this, "Please answer all questions before emailing results",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }

        else
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\n" + "Results: " + result +
                " out of " + total + "\n" + "Thank you for taking this quiz!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /*
    Method to start the quiz.
     */
    public void start(View view){
        ImageView startImage = findViewById(R.id.start_image);
        startImage.setVisibility(View.GONE);

        Button startButton = findViewById(R.id.start_button);
        startButton.setVisibility(View.GONE);

        EditText nameField = findViewById(R.id.name_field);
        nameField.setVisibility(View.VISIBLE);

        TextView startText = findViewById(R.id.start_text);
        startText.setVisibility(View.GONE);
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionOne() {

        int score = 0;

        int getState = groupOne.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_1_3);

        String nameField = editText.getText().toString();

        if(R.id.choice_1_3 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupOne.getCheckedRadioButtonId() != -1){
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionTwo() {

        int score = 0;

        int getState = groupTwo.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_2_1);

        String nameField = editText.getText().toString();

        if(R.id.choice_2_1 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupTwo.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionThree() {

        int score = 0;

        int getState = groupThree.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_3_2);

        String nameField = editText.getText().toString();

        if(R.id.choice_3_2 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupThree.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionFour() {

        int score = 0;

        int getState = groupFour.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_4_1);

        String nameField = editText.getText().toString();

        if(R.id.choice_4_1 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupFour.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionFive() {

        int score = 0;

        int getState = groupFive.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_5_3);

        String nameField = editText.getText().toString();

        if(R.id.choice_5_3 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupFive.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionSix() {

        int score = 0;

        int getState = groupSix.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_6_3);

        String nameField = editText.getText().toString();

        if(R.id.choice_6_3 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupSix.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionSeven() {

        int score = 0;

        int getState = groupSeven.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_7_2);

        String nameField = editText.getText().toString();

        if(R.id.choice_7_2 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupSeven.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionEight(){

        int score = 0;
        EditText answer = findViewById(R.id.name_field2);
        String getAnswer = answer.getText().toString();

        String nameField = editText.getText().toString();

        if (getAnswer.equalsIgnoreCase("Boston Celtics")){
            score++;
            answer.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") || !getAnswer.isEmpty()) {
            answer.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answer is correct SCORE is Incremented by 1. If answer is wrong
    SCORE is = to 0 & correct answer is highlighted AFTER submission.
     */
    public int questionNine() {

        int score = 0;

        int getState = groupNine.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(R.id.choice_9_2);

        String nameField = editText.getText().toString();

        if(R.id.choice_9_2 == getState){
            score++;
            radioButton.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (!nameField.matches("") && groupNine.getCheckedRadioButtonId() != -1) {
            radioButton.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }

    /*
    Method to check your answer. If answers are correct SCORE is Incremented by 1. If answers are wrong
    SCORE is = to 0 & correct answers are highlighted AFTER submission.
     */
    public int questionTen(){

        int score = 0;

        boolean state1 = checkBox1.isChecked(); boolean state2 = checkBox2.isChecked();
        boolean state3 = checkBox3.isChecked(); boolean state4 = checkBox4.isChecked();
        boolean state5 = checkBox5.isChecked(); boolean state6 = checkBox6.isChecked();

        String nameField = editText.getText().toString();

        checkBox1.setBackgroundColor(Color.TRANSPARENT);
        checkBox3.setBackgroundColor(Color.TRANSPARENT);
        checkBox4.setBackgroundColor(Color.TRANSPARENT);
        checkBox6.setBackgroundColor(Color.TRANSPARENT);

        if (state1 & !state2 & state3 & state4 & !state5 & state6){
            score++;
        }
        else if (nameField.matches("")){
            checkBox1.setBackgroundColor(Color.TRANSPARENT);
            checkBox3.setBackgroundColor(Color.TRANSPARENT);
            checkBox4.setBackgroundColor(Color.TRANSPARENT);
            checkBox6.setBackgroundColor(Color.TRANSPARENT);
        }
        else if (state2 | state5) {
            checkBox1.setBackgroundColor(Color.parseColor("#FBC02D"));
            checkBox3.setBackgroundColor(Color.parseColor("#FBC02D"));
            checkBox4.setBackgroundColor(Color.parseColor("#FBC02D"));
            checkBox6.setBackgroundColor(Color.parseColor("#FBC02D"));
        }
        return score;
    }
}
