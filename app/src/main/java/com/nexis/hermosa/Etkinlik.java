package com.nexis.hermosa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Etkinlik extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.anamenu:
                Intent a=new Intent(Etkinlik.this,MapsActivity.class);
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

    private ImageButton btnparti;
    private ImageButton btngezi;
   private ImageButton btnada;
  private ImageButton btnkamp;
    private ImageButton btndeniz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik);
       btnada=(ImageButton)findViewById(R.id.btnbasket);
       btndeniz=(ImageButton)findViewById(R.id.btnsatranc);
        btngezi=(ImageButton)findViewById(R.id.btnmac);
       btnkamp=(ImageButton)findViewById(R.id.btntiyatro);

        btngezi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Etkinlik.this,gezi.class);
                startActivity(intent);
                finish();
            }
        });
        btnkamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Etkinlik.this,kamp.class);
                startActivity(intent);
                finish();
            }
        });

        btndeniz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Etkinlik.this,deniz.class);
                startActivity(intent);
                finish();
            }
        });
        btnada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Etkinlik.this,ada.class);
                startActivity(intent);
                finish();
            }
        });


        btnparti=(ImageButton) findViewById(R.id.btnav);
        btnparti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Etkinlik.this,parti.class);
                startActivity(intent);
                finish();

            }
        });


    }
}