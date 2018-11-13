package com.example.faraz.studybuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditInfoActivity extends AppCompatActivity {
    EditText name,year,gender,email,classes,bio,major;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        name = findViewById(R.id.editText);
        year = findViewById(R.id.editText2);
        gender = findViewById(R.id.editText3);
        email = findViewById(R.id.editText4);
        classes = findViewById(R.id.editText5);
        bio = findViewById(R.id.editText6);
        major = findViewById(R.id.editText7);

    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sh = getSharedPreferences("MySharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("year",year.getText().toString());
        editor.putString("major",major.getText().toString());
        editor.putString("gender",gender.getText().toString());
        editor.putString("bio",bio.getText().toString());
        editor.putString("classes",classes.getText().toString());
        editor.putString("email",email.getText().toString());

    }
}
