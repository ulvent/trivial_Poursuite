package com.example.trivialpoursuite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trivialpoursuite.DataBase.DataSource;
import com.example.trivialpoursuite.Model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DataSource ds=null;
    private Button btnClassique,btnDisney,btnHP;
    private static final String GENRE="GENRE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds=new DataSource(this);
        try{
            ds.open();
            if(ds.readAllQuestion()==null){
                init();
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
        if(ds.getQuestionsByGenre("HarryP")==null){
            btnHP.setEnabled(false);
        }
    }

    public void goToClassique(View v){
        Intent i=new Intent(MainActivity.this, Categorie.class);
        i.putExtra(GENRE,"Classique");
        ds.close();
        startActivity(i);
    }

    public void updateDB(View v){
        ds.clearDB();
        init();
    }

    /*
    * Initialise la base de donnée
    * */
    private void init(){
        //Classique
            //Géographie
            ds.insertQuestion("Classique","geographie","Quelle est la langue la plus parlée au monde ?","Le mandarin");
            ds.insertQuestion("Classique","geographie","Au large de quel pays la Méditerranée se trouve l'île de Santorin ?","De la grèce");
            ds.insertQuestion("Classique","geographie","Conbien de fuseaux horaires travesent le Canada ?","Six");
            ds.insertQuestion("Classique","geographie","Dans quel état amèricain se trouve la vallée de la mort ?","En Californie");
            ds.insertQuestion("Classique","geographie","Comment pourrait se traduire le nom dez la 'Sierra Leone' ?","La montagne aux lions");
            ds.insertQuestion("Classique","geographie","Dans quelle ville se trouve la 'Statue de la libèrté'?","New York");
            ds.insertQuestion("Classique","geographie","Sur quel continent le Nil coule-t-il ?","Afrique");
            ds.insertQuestion("Classique","geographie","Outre la Belgique et le Luxembourg, quel est le troisième pays formant le Benelux ?","Les Pays-Bas");
            ds.insertQuestion("Classique","geographie","Où le trouve le volcan Olympus Mons ?","Sur Mars");
            ds.insertQuestion("Classique","geographie","Quel pays a pour capitale Sofia ?","Bulgarie");
            ds.insertQuestion("Classique","geographie","Où se trouve le lac le plus haut du monde ?","Dans la cordillière des Andes");
            ds.insertQuestion("Classique","geographie","Quel canal relie la Méditerranée à la Mer Rouge ?","Le canal de Suez");
            ds.insertQuestion("Classique","geographie","Sur quel site trouve-t-on les alignements de mégalithes ?","Carnac");
            ds.insertQuestion("Classique","geographie","Quel est le nom local du Fort Boyard ?","Le fort de l'inutile");
            ds.insertQuestion("Classique","geographie"," Dans quelle ville américaine se trouve le Golden Gate Bridge ?","San Francisco");
            //Histoire
            ds.insertQuestion("Classique","histoire","En quelle année, le Mur de Berlin est-il tombé ?","1989");
            ds.insertQuestion("Classique","histoire","En quelle année, la majorité a-t-elle été abaissée à 18 ans en France ?","1874");
            ds.insertQuestion("Classique","histoire","En quelle année, Louis XVI a-t-il été exécuté ?","1793");
            ds.insertQuestion("Classique","histoire","En quelle année, la première guerre du Golfe a-t-elle pris fin ?","1991");
            ds.insertQuestion("Classique","histoire","En quelle année, le IIIème Reich a-t-il capitulé ?","1945");
            ds.insertQuestion("Classique","histoire","En quelle année, en quelle année ont eu lieu les attentats du 11 septembre ?","2001");
            ds.insertQuestion("Classique","histoire","En quelle année, JFK a-t-il été assassiné ?","1963");
            ds.insertQuestion("Classique","histoire","En quelle année, l'homme a-t-il marché sur la lune ?","1969");
            ds.insertQuestion("Classique","histoire","Dans quelle ville Martin Luther King, pasteur et militant pour les droits civiques des Noirs Américains,  a-t-il été assassiné ?","Menphis");
            ds.insertQuestion("Classique","histoire","Quel pays a donné son indépendance à la République du Congo (ou Congo-Brazzavile) le 15 août 1960 ?","La France");
            ds.insertQuestion("Classique","histoire","Au cours de la Guerre de Troie, au XIIe siècle av. J.‑C., qui a tué Hector ?","Achille");
            ds.insertQuestion("Classique","histoire","Quel pays a cédé la Floride aux Américains en 1819 ?","L'Espagne");
            ds.insertQuestion("Classique","histoire","Quels soldats étaient surnommés les Tommies pendant la première Guerre Mondiale ?","Les Anglais");
            ds.insertQuestion("Classique","histoire","Dans l’Antiquité, quelles villes se sont affrontées lors des Guerres Puniques ?","Rome et Carthage");
            ds.insertQuestion("Classique","histoire","Quelle bataille a été gagnée par Napoléon en 1806 ?","Lena");
            //Sciences
            ds.insertQuestion("Classique","science","Qu'est-ce que le diaphragme ?","Un muscle");
            ds.insertQuestion("Classique","science","Combien de satellites naturels gravitent autour de la Terre ?","1");
            ds.insertQuestion("Classique","science","Combien font 122 x 12 ?","1464");
            ds.insertQuestion("Classique","science","Quel métal alcalin est symbolisé par la lettre K ?","Le Potassium");
            ds.insertQuestion("Classique","science","Quelles sont les deux plus grosses planètes du système solaire ?","Jupiter et Saturne");
            ds.insertQuestion("Classique","science","Comment appelle-t-on le réseau internet hertzien sans fil ?","WI-FI");
            ds.insertQuestion("Classique","science","Grâce à quel minerai obtient-on l'aluminium ?","La Bauxite");
            ds.insertQuestion("Classique","science","À quel scientifique de l’Antiquité l’invention de la vis a-t-elle été attribuée ?","Archimède");
            ds.insertQuestion("Classique","science","Quelle était la particularité de la brebis Dolly ?","C'est le premier mammifère cloné");
            ds.insertQuestion("Classique","science","Quelle période représente une décade ?","10 Jours");
            ds.insertQuestion("Classique","science","Qu’est-ce qu’un Pied-de-mouton ?","Un Champignon");
            ds.insertQuestion("Classique","science","Après l’éléphant, quel animal terrestre est le plus lourd ?","Le rhinocéros");

    }
}