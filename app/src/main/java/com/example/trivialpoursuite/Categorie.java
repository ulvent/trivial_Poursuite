package com.example.trivialpoursuite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trivialpoursuite.DataBase.DataSource;
import com.example.trivialpoursuite.Model.Question;

import java.util.ArrayList;
import java.util.Random;

public class Categorie extends AppCompatActivity {
    private String genre;
    private DataSource ds;
    private ArrayList<Question> lq=new ArrayList();
    private TextView tvTitle;
    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        Intent i=getIntent();
        genre=i.getStringExtra("GENRE");
        ds=new DataSource(this);
        try{
            ds.open();
            System.out.println("Ouverture de la DB OK");
        }catch(SQLiteException e){
            System.out.println("Erreur d'ouverture : "+e.getMessage());
        }
        tvTitle=findViewById(R.id.tvTitle);
        tvTitle.setText("Catégorie : "+genre);
        //btn Récup
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        initBtn();
    }

    public void goMenu(View v){
        Intent i=new Intent(Categorie.this,MainActivity.class);
        startActivity(i);
    }

    public void push(View v) {
        switch (v.getId()) {

            case (R.id.btn1):
                if(genre.equals("Classique")){
                    goToDetail("geographie");
                }
                break;

            case (R.id.btn2):
                if(genre.equals("Classique")){
                    goToDetail("science");
                }
                break;

            case (R.id.btn3):
                if(genre.equals("Classique")){
                    goToDetail("sport");
                }
                break;

            case (R.id.btn4):
                if(genre.equals("Classique")){
                    goToDetail("histoire");
                }
                break;

            case (R.id.btn5):
                if(genre.equals("Classique")){
                    goToDetail("arts");
                }
                break;

            case (R.id.btn6):
                if(genre.equals("Classique")){
                    goToDetail("culture");
                }
                break;
        }
    }

    private Question getAlt(){
        if(lq.size()-1==0){
            return lq.get(new Random().nextInt(lq.size()) + 0);
        }else{
            return lq.get(new Random().nextInt(lq.size()-1) + 0);
        }
    }

    private void initBtn(){
        System.out.println("genre : "+genre);
        ArrayList<String> list=new ArrayList();
        if(genre.equals("Classique")){
            list.add("Géographie");
            list.add("Science et nature");
            list.add("Sport et loisirs");
            list.add("Histoire");
            list.add("Arts et litératures");
            list.add("Culture générale");
            list.add("geographie");
            list.add("science");
            list.add("sport");
            list.add("histoire");
            list.add("arts");
            list.add("culture");
        }else if(genre.equals("Harry")){
            list.add("Poudlard");
            list.add("Animaux et créature magiques");
            list.add("Objets magiques");
            list.add("Personnages");
            list.add("Magie noire");
            list.add("Sortilèges et potions");
            list.add("poudlard");
            list.add("animaux");
            list.add("objets");
            list.add("personnages");
            list.add("noire");
            list.add("sorts");
        }else if(genre.equals("Disney")){
            list.add("Personnages");
            list.add("Personnages");
            list.add("Films");
            list.add("Science");
            list.add("Nature et animaux");
            list.add("Culture générale");
            list.add("personnage");
            list.add("science");
            list.add("sport");
            list.add("histoire");
            list.add("arts");
            list.add("culture");
        }

        BtnText(list);
    }

    private void goToDetail(String type){
        Intent i=new Intent(Categorie.this,Detail.class);
        lq.addAll(ds.getQuestionsByGenreAndType(type,genre));
        i.putExtra("GENRE",genre);
        i.putExtra("TYPE",type);
        i.putParcelableArrayListExtra("LIST",lq);
        i.putExtra("QUESTION",getAlt());
        ds.close();
        startActivity(i);
    }

    private void BtnText(ArrayList<String> btnText){
        btn1.setText(btnText.get(0));
        btn2.setText(btnText.get(1));
        btn3.setText(btnText.get(2));
        btn4.setText(btnText.get(3));
        btn5.setText(btnText.get(4));
        btn6.setText(btnText.get(5));
        if(ds.getQuestionsByGenreAndType(btnText.get(6),genre)==null){
            btn1.setEnabled(false);
            btn1.setBackgroundColor(Color.DKGRAY);
        }
        if(ds.getQuestionsByGenreAndType(btnText.get(7),genre)==null){
            btn2.setEnabled(false);
            btn2.setBackgroundColor(Color.DKGRAY);
        }
        if(ds.getQuestionsByGenreAndType(btnText.get(8),genre)==null){
            btn3.setEnabled(false);
            btn3.setBackgroundColor(Color.DKGRAY);
        }
        if(ds.getQuestionsByGenreAndType(btnText.get(9),genre)==null){
            btn4.setEnabled(false);
            btn4.setBackgroundColor(Color.DKGRAY);
        }
        if(ds.getQuestionsByGenreAndType(btnText.get(10),genre)==null){
            btn5.setEnabled(false);
            btn5.setBackgroundColor(Color.DKGRAY);
        }
        if(ds.getQuestionsByGenreAndType(btnText.get(11),genre)==null){
            btn6.setEnabled(false);
            btn6.setBackgroundColor(Color.DKGRAY);
        }
    }
}