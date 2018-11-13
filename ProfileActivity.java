package com.example.faraz.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Profile objects
        Profile name = new Profile("Name","Filler", "drawable://" + R.drawable.name);
        Profile email = new Profile("Email","Filler", "drawable://" + R.drawable.email);
        Profile gender = new Profile("Sex","Filler", "drawable://" + R.drawable.gender);
        Profile year = new Profile("Year","Filler", "drawable://" + R.drawable.year);
        Profile major = new Profile("Major","Filler", "drawable://" + R.drawable.major);
        Profile classes = new Profile("Classes","Filler", "drawable://" + R.drawable.classes);

        //Add the Profile objects to an ArrayList
        ArrayList<Profile> peopleList = new ArrayList<>();
        peopleList.add(name);
        peopleList.add(email);
        peopleList.add(gender);
        peopleList.add(year);
        peopleList.add(major);
        peopleList.add(classes);


        ListAdapter adapter = new ListAdapter(this, R.layout.activity_profile, peopleList);
        mListView.setAdapter(adapter);
    }

    public void editInfo(View view) {
        Intent intent = new Intent(this,EditInfoActivity.class);
        startActivity(intent);
    }
    public void gotoData(View view){
        Intent intent = new Intent(this,ClassSearchActivity.class);
        startActivity(intent);
    }
}

