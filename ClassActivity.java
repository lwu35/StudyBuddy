package com.example.faraz.studybuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ClassActivity extends AppCompatActivity {
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        ll = findViewById(R.id.layout);

    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPreferences",MODE_PRIVATE);
        Map<String,?> all = sh.getAll();
        Iterator it = all.entrySet().iterator();
        ArrayList<String[]> result = new ArrayList<String[]>();
        while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if (pairs.getKey().toString().startsWith("record")) {
                TextView text = new TextView(this);
                Button button = new Button(this);
                button.setText("See All Groups");
                text.setGravity(Gravity.CENTER_HORIZONTAL);
                text.setTextSize(30);
                text.setText(pairs.getValue().toString());
                ll.addView(text);
            }
        }
    }
    public void classSearch(View view){
        Intent intent = new Intent(this,ClassSearchActivity.class);
        startActivity(intent);
    }
}
