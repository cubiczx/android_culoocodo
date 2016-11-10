package com.example.xpalacin.culoocodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public final static String OPTION = "com.example.xpalacin.culoocodo";
    private static int aciertos = 0;
    private static int n_questions = 2;
    private static  Pregunta[] arrayPreguntas = new Pregunta[n_questions];
    private static int currentQuestionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.xpalacin.culoocodo.R.layout.activity_main);

        arrayPreguntas[0] = new Pregunta(true, com.example.xpalacin.culoocodo.R.mipmap.p1, com.example.xpalacin.culoocodo.R.mipmap.r1);
        arrayPreguntas[1] = new Pregunta(false, com.example.xpalacin.culoocodo.R.mipmap.p2, com.example.xpalacin.culoocodo.R.mipmap.r2);

        //setContentView(R.layout.activity_main);
        ImageView img = (ImageView)findViewById(com.example.xpalacin.culoocodo.R.id.imageViewPregunta);

        Pregunta question = getCurrentQuestion();

        img.setImageResource(question.getImageId());
    }

    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
    }

    public static int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public static void nextQuestion() {
        currentQuestionId = getCurrentQuestionId() + 1;
    }

    public static Boolean isLastQuestion(){
        if (getCurrentQuestionId() == 1){
            return true;
        }else{
            return false;
        }
    }

    public static Pregunta getCurrentQuestion() {
        return arrayPreguntas[currentQuestionId];
    }

    public static Respuesta getCurrentAnswer() {
        return arrayPreguntas[currentQuestionId].getAsnwer();
    }

    public static void restart(){
        currentQuestionId = 0;
        aciertos = 0;
    }

    public static int getHits(){
        return aciertos;
    }

    /** Called when the user clicks the Send button */
    public void validate(View view) {
        // Do something in response to button

        Boolean option = false;

        switch (view.getId()) {
            case com.example.xpalacin.culoocodo.R.id.button_ass:
                // do something
                if (arrayPreguntas[currentQuestionId].getType() == true){
                    option = true;
                    aciertos =  aciertos + 1;
                }
                break;
            case com.example.xpalacin.culoocodo.R.id.button_elbow:
                // do something else
                if (arrayPreguntas[currentQuestionId].getType() == false){
                    option = true;
                    aciertos =  aciertos + 1;
                }
                break;
        }
        this.showAnswer(option);
    }

    public void showAnswer(Boolean option) {
        Intent intentAnswer = new Intent(this, DisplayMessageActivity.class);
        intentAnswer.putExtra(OPTION,option);
        startActivity(intentAnswer);
    }

    /**
     * Called when the user clicks the Next button
     */
    public void restart(View view) {
        restart();
        Intent intentQuestion = new Intent(this, MainActivity.class);
        startActivity(intentQuestion);
    }

}
