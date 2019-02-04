package fr.asheart.mgvpc;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class Accueil extends AppCompatActivity {

    private LienApi     LA  = new LienApi();
    public  String      mdp = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        /*pour rendre android plus tolérant au sujet de l'alourdissement de la gui */
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public  void ClickMdpButton(View view) {
        String btnPush = view.getTag().toString();
        this.mdp += btnPush;

        try {
            String urlTrous = "connexionApp.php?key=%s";
            String url      = String.format(urlTrous, this.mdp);
            JSONArray jo    = LA.toApiRequest(url);

            Log.e("YOUSK2 MDP", jo+"");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    public  void ClickSuppButton(View view) {
        this.mdp = "";
    }
}
