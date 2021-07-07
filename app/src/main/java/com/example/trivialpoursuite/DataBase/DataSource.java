package com.example.trivialpoursuite.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.trivialpoursuite.Model.Question;

import java.util.ArrayList;

public class DataSource {
    private SQLiteDatabase db;
    private MySQLiteHelper mh;

    public DataSource(Context context) {
        mh = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = mh.getWritableDatabase();
    }

    public void close() {
        mh.close();
    }

    /*
     * Donne les questions dans le thème et la catégorie voulue
     * */
    public ArrayList<Question> getQuestionsByGenreAndType(String type, String genre) {
        ArrayList<Question> lQ = new ArrayList<>();
        Cursor c = db.rawQuery("select * from Questions where type=? and genre=?", new String[]{type,genre});
        if (c.getCount() != 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                try {
                    int id = c.getInt(0);
                    String genreG = c.getString(1);
                    String typeG = c.getString(2);
                    String question = c.getString(3);
                    String answer = c.getString(4);
                    lQ.add(new Question(id, genreG, typeG, question, answer));
                } catch (Exception e) {
                    System.out.println("ERREUR : Pas de création");
                }
                c.moveToNext();
            }
            return lQ;
        }else{
            return null;
        }
    }

    /*
     * Donne les questions dans le thème voulu
     * */
    public ArrayList<Question> getQuestionsByGenre(String genre) {
        ArrayList<Question> lQ = new ArrayList<>();
        Cursor c = db.rawQuery("select * from Questions where genre=?", new String[]{genre});
        if (c.getCount() != 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                try {
                    int id = c.getInt(0);
                    String genreG = c.getString(1);
                    String type = c.getString(2);
                    String question = c.getString(3);
                    String answer = c.getString(4);
                    lQ.add(new Question(id, genreG, type, question, answer));
                } catch (Exception e) {
                    System.out.println("ERREUR : Pas de création");
                }
                c.moveToNext();
            }
            return lQ;
        }else{
            return null;
        }
    }

    /*
     * insert une question dans la db
     * */
    public void insertQuestion(String genre, String type, String question, String answer) {
        ContentValues values = new ContentValues();
        values.put("genre", genre);
        values.put("type", type);
        values.put("question", question);
        values.put("answer", answer);
        db.insert("Questions", null, values);
    }

    /*
     * Lit toutes les question de la table Questions
     * */
    public ArrayList<Question> readAllQuestion() {
        ArrayList<Question> lQ = new ArrayList<>();
        Cursor c = db.rawQuery("select * from Questions", null);
        if (c.getCount() != 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                try {
                    int id = c.getInt(0);
                    String genre = c.getString(1);
                    String type = c.getString(2);
                    String question = c.getString(3);
                    String answer = c.getString(4);
                    lQ.add(new Question(id, genre, type, question, answer));
                } catch (Exception e) {
                    System.out.println("ERREUR : Pas de création");
                }
                c.moveToNext();
            }
            return lQ;
        } else {
            return null;
        }
    }

    /*
    * Vide la DB
    * */
    public void clearDB(){
        db.execSQL("delete from Questions");
    }
}
