package com.example.trivialpoursuite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trivialpoursuite.DataBase.DataSource;
import com.example.trivialpoursuite.Model.Initilize;
import com.example.trivialpoursuite.Model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DataSource ds=null;
    private Button btnClassique,btnDisney,btnHP;
    private Initilize init;
    private static final String GENRE="GENRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DataSource(this);
        try{
            ds.open();
            if(ds.readAllQuestion()==null){
                init=new Initilize(ds,this);
                init.all();
            }
            System.out.println("Ouverture de la DB OK");
        }catch(SQLiteException e){
            System.out.println("Erreur d'ouverture : "+e.getMessage());
        }
        //récupération des bouttons
        btnClassique=findViewById(R.id.btnClass);
        btnDisney=findViewById(R.id.btnDisney);
        btnHP=findViewById(R.id.btnHP);
        //test des catégorie
        if(ds.getQuestionsByGenre("Classique")==null){
            btnClassique.setEnabled(false);
        }
        if(ds.getQuestionsByGenre("Disney")==null){
            btnDisney.setEnabled(false);
        }
        if(ds.getQuestionsByGenre("Harry")==null){
            btnHP.setEnabled(false);
        }
    }

    public void goToClassique(View v){
        Intent i=new Intent(MainActivity.this, Categorie.class);
        i.putExtra(GENRE,"Classique");
        ds.close();
        startActivity(i);
    }

    public void goToHarry(View v){
        Intent i=new Intent(MainActivity.this, Categorie.class);
        i.putExtra(GENRE,"Harry");
        ds.close();
        startActivity(i);
    }

    public void goToDisney(View v){
        Intent i=new Intent(MainActivity.this, Categorie.class);
        i.putExtra(GENRE,"Disney");
        ds.close();
        startActivity(i);
    }

    public void goToAdd(View v){
        Intent i=new Intent(MainActivity.this, AddQuestion.class);
        ds.close();
        startActivity(i);
    }

    public void updateDB(View v){
        ds.clearDB();
        init.all();
    }

}