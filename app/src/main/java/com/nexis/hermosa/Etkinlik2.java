package com.nexis.hermosa;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class Etkinlik2 extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.anamenu:
                Intent a=new Intent(Etkinlik2.this,MapsActivity.class);
                startActivity(a);
                break;
            case R.id.cikisyap:

                new AlertDialog.Builder(this)
                        .setTitle("Çıkış")
                        .setMessage("Uygulamadan çıkmak istediğinize emin misiniz?")
                        .setNegativeButton(android.R.string.no, null)
                        .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                                setIntent.addCategory(Intent.CATEGORY_HOME);
                                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(setIntent);

                            }
                        }).create().show();
        }
        return super.onOptionsItemSelected(item);
    }
    private ImageButton btnburay;
    private ImageButton btntiyatro;
    private ImageButton btnmac;
    private ImageButton btnsatranc;
    private ImageButton btnbasket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik2);
        btnburay=(ImageButton)findViewById(R.id.btnav);
        btntiyatro=(ImageButton)findViewById(R.id.btntiyatro);
        btnmac=(ImageButton)findViewById(R.id.btnmac);
        btnsatranc=(ImageButton)findViewById(R.id.btnsatranc);
        btnbasket=(ImageButton)findViewById(R.id.btnbasket);

        btnburay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Etkinlik2.this,buray.class);
                startActivity(i);
                finish();
            }
        });

        btntiyatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Etkinlik2.this,tiyatro.class);
                startActivity(i);
                finish();
            }
        });
        btnmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Etkinlik2.this,mac.class);
                startActivity(i);
                finish();
            }
        });

        btnsatranc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Etkinlik2.this,satranc.class);
                startActivity(i);
                finish();
            }
        });

        btnbasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Etkinlik2.this,basket.class);
                startActivity(i);
                finish();
            }
        });
    }
}