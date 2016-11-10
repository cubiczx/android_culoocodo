package com.example.xpalacin.culoocodo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class DisplayMessageActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.xpalacin.culoocodo.R.layout.activity_display_message);

        ImageView img = (ImageView)findViewById(com.example.xpalacin.culoocodo.R.id.imageViewRespuesta);

        Respuesta answer = MainActivity.getCurrentAnswer();
        img.setImageResource(answer.getImageId());

        Boolean option = getIntent().getExtras().getBoolean((MainActivity.OPTION));
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        String resultText = getString(com.example.xpalacin.culoocodo.R.string.fail);
        if (option) {
            resultText = getString(com.example.xpalacin.culoocodo.R.string.success);
        }

        String texto = resultText;

        textView.setText(texto);

        ViewGroup layout = (ViewGroup) findViewById(com.example.xpalacin.culoocodo.R.id.activity_display_message);
        layout.addView(textView);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Respuesta") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    /**
     * Called when the user clicks the Next button
     */
    public void nextQuestion(View view) {
        if (MainActivity.isLastQuestion()){
            Intent intentResults = new Intent(this, ResultsActivity.class);
            startActivity(intentResults);
        }else{
            MainActivity.nextQuestion();
            Intent intentQuestion = new Intent(this, MainActivity.class);
            startActivity(intentQuestion);
        }

    }
}
