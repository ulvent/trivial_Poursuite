package com.example.trivialpoursuite.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    private int id;
    private String genre;
    private String type;
    private String question;
    private String answer;

    public Question(int id, String genre, String type, String question, String answer) {
        this.id = id;
        this.genre = genre;
        this.type = type;
        this.question = question;
        this.answer = answer;
    }

    protected Question(Parcel in) {
        id = in.readInt();
        genre = in.readString();
        type = in.readString();
        question = in.readString();
        answer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(genre);
        dest.writeString(type);
        dest.writeString(question);
        dest.writeString(answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
