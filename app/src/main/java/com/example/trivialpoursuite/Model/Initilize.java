package com.example.trivialpoursuite.Model;

import android.content.Context;
import android.widget.Toast;

import com.example.trivialpoursuite.DataBase.DataSource;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Initilize {
    private DataSource ds;
    private Context context;
    public Initilize(DataSource ds, Context context){
        this.ds=ds;
        ds.open();
        this.context=context;
    }

    public void all(){
        classique();
    }
    private void classique(){
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
        ds.insertQuestion("Classique","science","Qu'est ce qu'est une exuvie ?","La peau résultant de la transformation d'une nymphe en imago");
        ds.insertQuestion("Classique","science","Quelle est la consommation d’eau pour une chasse d’eau tirée ?","12 litres");
        ds.insertQuestion("Classique","science","À quelle vitesse se dégrade une cannette de soda dans la nature ?","Jusqu'à 100 ans");
        //sport et loisir
        ds.insertQuestion("Classique","sport","Quel sport est pratiqué lors de Roland Garros ?","Le Tennis");
        ds.insertQuestion("Classique","sport","Quel sport est pratiqué lors de Roland Garros ?","Le Tennis");
        ds.insertQuestion("Classique","sport","À quelle hauteur se trouve le filet de volley pour une compétition masculine ? 2,24m/2,43m/2,78m","2,43m");
        ds.insertQuestion("Classique","sport","Combien de fois, Alain Prost a-t-il été champion du monde de Formule 1 ? 2/3/4","4");
        ds.insertQuestion("Classique","sport","Durant quel mois de déroule la course du Paris-Roubaix ?","Avril");
        ds.insertQuestion("Classique","sport","En football, que donne-t-on en guise d'avertissement ?","Un carton jaune");
        ds.insertQuestion("Classique","sport","Dans quel sport pratique-t-on le saut à la perche ?","En Athlétisme");
        ds.insertQuestion("Classique","sport","Dans quel sport pratique-t-on le saut à la perche ?","En Athlétisme");
        ds.insertQuestion("Classique","sport","Combien de joueurs compte une équipe de volley-ball sur le terrain ? 4/6/8/10","6");
        ds.insertQuestion("Classique","sport","Quel accessoire de natation a été interdit en 2010 ?","La combinaison");
        ds.insertQuestion("Classique","sport","Qu'est-ce qu'un catamaran ?","Un bateau");
        ds.insertQuestion("Classique","sport","Dans quel sport les Bleues, surnommées les « Braqueuses » évoluent-elles ?","Au basket");
        ds.insertQuestion("Classique","sport","Qu'appelle-t-on la Grande Boucle ?","Le tour de France");
        ds.insertQuestion("Classique","sport","Quel poste occupait le célèbre basketteur Shaquille O’Neal ?","Pivot");
        ds.insertQuestion("Classique","sport","Comment nomme-t-on l'équipement de combat d'un karatéka ?","Le kimono");
        //Arts et litérature
        ds.insertQuestion("Classique","arts","À quel mouvement artistique appartenaient Rembrandt, Vermeer,  Velázquez ou Rubens ?","Le baroque");
        ds.insertQuestion("Classique","arts","Qui a peint le célèbre tableau « Café de nuit à Arles »  ?","Vincent Van Gogh");
        ds.insertQuestion("Classique","arts","Dans quelle ville européenne se trouve le musée Guggenheim ?","Bilbao");
        ds.insertQuestion("Classique","arts","À quel peintre doit-on « La Naissance de Vénus » ?","Botticelli");
        ds.insertQuestion("Classique","arts","Dans quel musée, le tableau « Les Noces de Cana » de Véronèse est-il exposé ?","Le Louvre à Paris");
        ds.insertQuestion("Classique","arts","À quel auteur doit-on le roman « Le Comte de Monte-Cristo » ?","Alexandre Dumas");
        ds.insertQuestion("Classique","arts","À quel auteur doit-on le roman « Moby Dick » ?","Herman Melville");
        ds.insertQuestion("Classique","arts","Qui est le fidèle compagnon de Sherlock Holmes ?","Watson");
        ds.insertQuestion("Classique","arts","Quel est le nom du cheval de Lucky Luke ?","Jolly Jumper");
        ds.insertQuestion("Classique","arts","Quel est le prénom du capitaine Haddock ?","Archibald");
        ds.insertQuestion("Classique","arts","Dans quelle ville américaine Tintin arrive-t-il dans l’album Tintin en Amérique ?","Chicago");
        ds.insertQuestion("Classique","arts","À quelle époque se déroulent les aventures d’Alix ?","Dans la Rome antique");
        ds.insertQuestion("Classique","arts","Quel Dalton est le plus grand et le plus bête dans la BD Lucky Luke ?","Averell");
        ds.insertQuestion("Classique","arts","Comment s’appelle le meilleur ami du petit Spirou ?","Vertignasse");
        ds.insertQuestion("Classique","arts","Quel est le prénom du Capitaine Crochet, ennemi de Peter Pan ?","James");
        //cultures G
        ds.insertQuestion("Classique","culture","De quelle ville française le cannelé est-il une spécialité ?","Bordeaux");
        ds.insertQuestion("Classique","culture","Quelle est la capitale de l’Inde ?","New Delhi");
        ds.insertQuestion("Classique","culture","Quel arbre produit la noix de pécan ?","Le pacanier");
        ds.insertQuestion("Classique","culture","Quel groupe a interprété la chanson « Hotel California » ?","Eagle");
        ds.insertQuestion("Classique","culture","Dans quel pays est né le tango ?","L'argentine");
        ds.insertQuestion("Classique","culture","En France, à partir de quel âge peut-on conduire un bus ?","21 ans");
        ds.insertQuestion("Classique","culture","De quel pays, la ville Stockholm est-elle la capitale ?","La Suèdde");
        ds.insertQuestion("Classique","culture","Quel arbre produit le liège ?","Le chêne");
        ds.insertQuestion("Classique","culture","Combien y a-t-il de décimètres (dm) dans 5 mètres ?","50 dm");
        ds.insertQuestion("Classique","culture","Quelle pâtisserie est une spécialité d'Amiens et de Nancy ?","Le macaron");
        ds.insertQuestion("Classique","culture","Quel est le vrai nom du Pont d’Avignon ?","Le pont Saint-Bénézet");
        ds.insertQuestion("Classique","culture","Quelle plante carnivore est également appelée “attrape-mouche” ?","La dionée");
        ds.insertQuestion("Classique","culture","Quel est le théorème de Pythagore  ?","La somme des carrés des côtés est égale au carré de l'hypoténuse");
        ds.insertQuestion("Classique","culture","Dans quelle discipline décerne-t-on le Prix Goncourt ?","La littérature");
        ds.insertQuestion("Classique","culture","Comment se prénommait l'épouse du Roi Arthur ?","Guenièvre");
    }
}
