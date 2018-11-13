package com.example.faraz.studybuddy;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;


public class ClassSearchActivity extends AppCompatActivity {
    TextView quarterText;
    LinearLayout linearlayout;
    TextView text1;
    LinearLayout linearLayout2;
    ArrayList<Integer> beginDates = new ArrayList<Integer>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_search);
        linearLayout2 = findViewById(R.id.linearlayout1);
        quarterText = findViewById(R.id.quarter);
        linearlayout = findViewById(R.id.ll);
        try {
            getQuarter();
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    public void getQuarter() throws IOException {
        InputStream is =
                getAssets().open("schedule.html");
        Document doc =
                Jsoup.parse(convertStreamToString(is));
        String dates =
                doc.getElementsByTag("p").toString();
        Calendar cal1 =
                new GregorianCalendar(TimeZone.getTimeZone("America/Santa_Cruz"));
        String[] date =
                dates.split("[\\@&.?$</>]+");
        int currmonth =
                formatDate(cal1);
        for(int i = 0; i < date.length; i++){
            if(date[i].equals("Instruction Begins")){
                beginDates.add(
                        monthInt(date[i+4].
                                substring(0,date[i+4].length()-2).trim()));
            }
        }
        if(beginDates.get(0)<= currmonth && currmonth > beginDates.get(1)){
            updateQuarter("Fall");
        }
        if(beginDates.get(1) <= currmonth && currmonth < beginDates.get(2)){
            updateQuarter("Winter");
        }
    }
    public void updateQuarter(String quarter){
        quarterText.setText(quarter + " Quarter");
    }
    public void getData(){
        ArrayList<String> classes = new ArrayList<String>();
        InputStream is =
                null;
        try {
            is = getAssets().open("actualschedule.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        Document doc =
                Jsoup.parse(convertStreamToString(is));

        for(Element element:doc.getElementsByAttributeValueContaining("href","Fall18")){
            builder.append(element.attr("href"));
        }
        String[] val = builder.toString().split("/");
        for(int i = 0; i < val.length; i = i + 2){
            for(Element element: doc.getElementsByAttribute("href")){
                if(val[i].contains("cmps") && element.html().contains(val[i].toUpperCase())){
                    classes.add(element.html());
                }
            }
        }
        for(String string : classes){
            text1 = new TextView(this);
            text1.setText(string);
            linearlayout.addView(text1);
        }
    }
    public int formatDate(Calendar calendar){
        SimpleDateFormat df =
                new SimpleDateFormat("d-M");
        df.setCalendar(calendar);
        return Integer.parseInt(trimString(df.format(calendar.getTime())));
    }
    public int monthInt(String month) {
        switch (month) {
            case "January":
                month = "1";
                break;

            case "Febuary":
                month = "2";
                break;

            case "March":
                month = "3";
                break;

            case "April":
                month = "4";
                break;

            case "May":
                month = "5";
                break;

            case "June":
                month = "6";
                break;

            case "July":
                month = "7";
                break;

            case "August":
                month = "8";
                break;

            case "September":
                month = "9";
                break;

            case "October":
                month = "10";
                break;

            case "November":
                month = "11";
                break;

            case "December":
                month = "12";
                break;
        }
        return Integer.parseInt(month);

    }
    public String trimString(String string){
        if(string.substring(string.length() - 2).equals("-"))
            return string.substring(string.length() - 1);
        else{
            return string.substring(string.length() - 2);
        }
    }
}
