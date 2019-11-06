package com.example.heros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class HeroesListActivity extends AppCompatActivity {
    private String json;
    private InputStream inputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputStream = getResources().openRawResource(R.raw.heroes);
        json = readTextFile(inputStream);
    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
    public void createJson(String jsonString) {
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Hero[] heros =  gson.fromJson(jsonString, Hero[].class);
        // convert your array to a list using the Arrays utility class
        List<Hero> heroList = Arrays.asList(heros);
    }
}

