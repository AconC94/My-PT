package com.example.andrew.my_pt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class UserAct extends AppCompatActivity implements View.OnClickListener  {

    private FirebaseAuth firebaseAuth;
    private TextView useremail;

    private Button buttonLogout;
    private Button buttonUserInfo;
    private Button buttonPdf;
    private Button tracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

       ;

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null)
        {
            finish();
            startActivity(new Intent(this,LoginAct.class));
        }

        FirebaseUser currentuser = firebaseAuth.getCurrentUser();


        useremail =(TextView) findViewById(R.id.useremail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonUserInfo = (Button) findViewById(R.id.buttonUserInfo);
        buttonPdf = (Button) findViewById(R.id.buttonPdf);
        tracker = (Button) findViewById(R.id.tracker);

        useremail.setText("Welcome" + currentuser.getEmail());
        buttonLogout.setOnClickListener(this);
        buttonUserInfo.setOnClickListener(this);
        buttonPdf.setOnClickListener(this);
        tracker.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v == buttonLogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginAct.class));
        }
        else if(v == buttonUserInfo)
        {
            Log.d("HIT","METHOD");
            startActivity(new Intent(this,userinfo.class));
        }
        else if(v == buttonPdf)
        {
            startActivity(new Intent(this,pdf.class));
        }
        else if(v == tracker)
        {
            //Toast.makeText(getApplicationContext(),"TRACKER HIT",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,tracker.class));
        }
    }
}
