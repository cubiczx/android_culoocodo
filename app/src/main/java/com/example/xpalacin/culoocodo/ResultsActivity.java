package com.example.xpalacin.culoocodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private String resultadosText = "vez";
    private String resultadosTextFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.xpalacin.culoocodo.R.layout.activity_results);
        TextView resultadosTextView = (TextView)findViewById(com.example.xpalacin.culoocodo.R.id.resultados_content);
        if (MainActivity.getHits() > 1){
            resultadosTextFinal = "veces";
        }else{
            resultadosTextFinal = "vez";
        }
        System.out.println(MainActivity.getHits());
        resultadosText = "Has acertado " + MainActivity.getHits() + " " + resultadosTextFinal;
        System.out.println(resultadosText);
        resultadosTextView.setText(resultadosText);
    }

    /**
     * Called when the user clicks the Next button
     */
    public void restart(View view) {
        MainActivity.restart();
        Intent intentQuestion = new Intent(this, MainActivity.class);
        startActivity(intentQuestion);
    }
}
