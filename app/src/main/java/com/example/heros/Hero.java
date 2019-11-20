package com.example.heros;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.*;

public class Hero implements Parcelable {
    private String name;
    private String description;
    private String superpower;
    private int ranking;
    private String image;

    public Hero() {
    }

    protected Hero(Parcel in) {
        name = in.readString();
        description = in.readString();
        superpower = in.readString();
        ranking = in.readInt();
        image = in.readString();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSuperpower() {
        return superpower;
    }

    public int getRanking() {
        return ranking;
    }

    public String getImage() {
        return image;
    }
    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(superpower);
        parcel.writeInt(ranking);
        parcel.writeString(image);
    }
}
