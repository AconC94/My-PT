package com.example.andrew.my_pt;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class tracker extends AppCompatActivity {

    TabHost tabHost;
    TextView goal;
    TextView remaining;
    TextView food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        TextView goal = (TextView) findViewById(R.id.goal);
        TextView remaining = (TextView) findViewById(R.id.remaining);
        TextView food = (TextView) findViewById(R.id.food);



        setSupportActionBar(toolbar);

        SQLiteDatabase db = openOrCreateDatabase("ListDB", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("select * from list where name = name ", null);
        String hit = "hit";
        Log.d("hit", hit);

        if (c.moveToFirst()) {
            Log.d("IF HIT after click", c.getString(0));
            double bmr;
            int weight = Integer.parseInt(c.getString(1));
            int height = Integer.parseInt(c.getString(2));
            int age = Integer.parseInt(c.getString(3));
            Float activity = Float.parseFloat(c.getString(4));
            int acl = activity.intValue();

            bmr = 66 + (13.7 * weight) + (5 * height )  - (6.8 * age)  ;
            //name.setText(c.getString(0));
            //height.setText(c.getString(2));

            double calories =  bmr * acl/2;
            int a = (int) Math.round(calories);
            String Scalories = ""+a;
            goal.setText(Scalories);
            remaining.setText(Scalories);
            // age.setText(c.getString(3));
            // float x  = Float.parseFloat(c.getString(4));
            // actLevel.setRating(x);
        }


            TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Breakfast");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Breakfast");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Lunch");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lunch");
        host.addTab(spec);
        //Tab 2
        spec = host.newTabSpec("Dinner");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Dinner");
        host.addTab(spec);
        //Tab 2
        spec = host.newTabSpec("Snacks");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Snacks");
        host.addTab(spec);
    }

}
