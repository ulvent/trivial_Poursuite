package com.example.trivialpoursuite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.trivialpoursuite.DataBase.DataSource;
import com.example.trivialpoursuite.Model.Question;

import java.util.ArrayList;
import java.util.Random;

public class Detail extends AppCompatActivity {
    private String genre,type;
    private DataSource ds;
    private ArrayList<Question> lq;
    private Question q;
    private TextView tvDetail,tvQuestion,tvAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i=getIntent();
        genre=i.getStringExtra("GENRE");
        type=i.getStringExtra("TYPE");
        lq=i.getParcelableArrayListExtra("LIST");
        q=i.getParcelableExtra("QUESTION");
        ds=new DataSource(this);
        try{
            ds.open();
            System.out.println("Ouverture de la DB OK");
        }catch(SQLiteException e){
            System.out.println("Erreur d'ouverture : "+e.getMessage());
        }
        tvDetail=findViewById(R.id.tvDetail);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvAnswer=findViewById(R.id.tvAnswer);
        tvDetail.setText(genre+ " : "+type);
        tvQuestion.setText("Question : \n\n"+q.getQuestion());
        tvAnswer.setText("\nRéponse : "+q.getAnswer());
    }

    public void ChangeQuestion(View v){
        if(lq.size()-1==0){
            q=lq.get(new Random().nextInt(lq.size()) + 0);
        }else{
            q= lq.get(new Random().nextInt(lq.size()-1) + 0);
        }
        tvQuestion.setText("Question : \n\n"+q.getQuestion());
        tvAnswer.setText("\nRéponse : "+q.getAnswer());
    }

    public void retour(View v){
        Intent i=new Intent(Detail.this,Categorie.class);
        i.putExtra("GENRE",genre);
        startActivity(i);
    }
}