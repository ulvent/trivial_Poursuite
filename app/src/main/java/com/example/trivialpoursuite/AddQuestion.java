package com.example.trivialpoursuite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.trivialpoursuite.DataBase.DataSource;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddQuestion extends AppCompatActivity {
    private Spinner sp,sp2;
    private EditText quest,answer;
    private int pos=-1,pos2=-1;
    private DataSource ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        sp=findViewById(R.id.sp);
        sp2=findViewById(R.id.sp2);
        quest=findViewById(R.id.quest);
        answer=findViewById(R.id.answer);
        ds=new DataSource(this);
        try{
            ds.open();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        ArrayAdapter<CharSequence> adapterSp=ArrayAdapter.createFromResource(this,R.array.theme, android.R.layout.simple_spinner_dropdown_item);
        adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapterSp);
        ArrayAdapter<CharSequence> adapterSp2=null;
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
                if(pos==0){
                    ArrayAdapter<CharSequence> adapterSp2=ArrayAdapter.createFromResource(AddQuestion.this,R.array.catClass, android.R.layout.simple_spinner_dropdown_item);
                    adapterSp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp2.setAdapter(adapterSp2);
                }else if(pos==1){
                    ArrayAdapter<CharSequence> adapterSp2=ArrayAdapter.createFromResource(AddQuestion.this,R.array.catDisney, android.R.layout.simple_spinner_dropdown_item);
                    adapterSp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp2.setAdapter(adapterSp2);
                }else if(pos==2){
                    ArrayAdapter<CharSequence> adapterSp2=ArrayAdapter.createFromResource(AddQuestion.this,R.array.catHarry, android.R.layout.simple_spinner_dropdown_item);
                    adapterSp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp2.setAdapter(adapterSp2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos2=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void add(View v){
        String theme=getTheme(pos);
        if(theme!=null){
            if(quest.getText().toString().isEmpty()==false && answer.getText().toString().isEmpty()==false){
                String cat=getCategorie(pos2);
                if(cat!=null){
                    String qt=quest.getText().toString();
                    String as=answer.getText().toString();
                    System.out.println("Theme : "+theme+"\nCatégorie : "+cat+"\nQuestion : "+qt+"\nRéponse : "+as);
                    ds.insertQuestion(theme,cat,qt,as);
                }
            }else{
                Toast.makeText(this,"Erreur : Question ou réponse vide",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Erreur : Thème incorrect",Toast.LENGTH_SHORT).show();
        }
    }

    private String getTheme(int theme){
        if(theme==0){
            return "Classique";
        }else if(theme==1){
            return "Disney";
        }else if(theme==2){
            return "Harry";
        }
        return null;
    }

    private String getCategorie(int theme){
        if(pos==0){
            if(theme==0){
                return "geographie";
            }else if(theme==1){
                return "science";
            }else if(theme==2){
                return "sport";
            }else if(theme==3){
                return "histoire";
            }else if(theme==4){
                return "arts";
            }else if(theme==5){
                return "culture";
            }
        }else if(pos==1){//Disney
            if(theme==0){
                return "personnage";
            }else if(theme==1){
                return "science";
            }else if(theme==2){
                return "sport";
            }else if(theme==3){
                return "histoire";
            }else if(theme==4){
                return "arts";
            }else if(theme==5){
                return "culture";
            }
        }else if(pos==2){//Harry potter
            if(theme==0){
                return "poudlard";
            }else if(theme==1){
                return "animaux";
            }else if(theme==2){
                return "objets";
            }else if(theme==3){
                return "personnages";
            }else if(theme==4){
                return "noire";
            }else if(theme==5){
                return "sorts";
            }
        }
        return null;
    }

    public void goToMenu(View v){
        Intent i=new Intent(AddQuestion.this,MainActivity.class);
        startActivity(i);
    }
}