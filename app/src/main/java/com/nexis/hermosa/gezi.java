package com.nexis.hermosa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class gezi extends AppCompatActivity {
    private Button btnkat;
    private TextView txtKalanhak;
    private int kalan=15;
    private ImageButton btnHarita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezi);
        txtKalanhak = (TextView) findViewById(R.id.txtKalanhak);
        btnkat = (Button) findViewById(R.id.btnkat);

        btnHarita=(ImageButton)findViewById(R.id.btnHarita);
        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("geo:41.185058,28.9720535?q=Belgrad Ormanı");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        btnkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gezi.this,geziKayit.class);
                kalan--;
                String kalann=String.valueOf(kalan);
                txtKalanhak.setText("kalan kişi sayısı: "+kalann);
                Toast.makeText(gezi.this,"kalan kontenjan: "+kalan,Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });

    }
}