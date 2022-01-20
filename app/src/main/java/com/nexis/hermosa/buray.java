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

import com.google.android.gms.maps.model.MarkerOptions;

public class buray extends AppCompatActivity {
    private Button btnkat;
    private TextView txtKalanhak;
    private int kalan=1000;
    private VideoView video;
    private MediaController media;
    private ImageButton btnHarita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buray);
        txtKalanhak = (TextView) findViewById(R.id.txtKalanhak);
        btnkat = (Button) findViewById(R.id.btnkat);
        btnHarita=(ImageButton)findViewById(R.id.btnHarita);
        btnHarita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("geo:41.04623110035377, 28.990073013050356?q=Harbiye, Cemil Topuzlu Açık Hava Tiyatrosu, Taşkışla Caddesi, Şişli/İstanbul");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
        media = new MediaController(this);
        video = (VideoView) findViewById(R.id.video);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.burayvideo);
        video.setVideoURI(uri);
        video.setMediaController(media);
        media.setAnchorView(video);

        video.start();


        btnkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(buray.this,buraykayit.class);
                kalan--;
                String kalann=String.valueOf(kalan);
                txtKalanhak.setText("kalan kişi sayısı: "+kalann);
                Toast.makeText(buray.this,"kalan kontenjan: "+kalan,Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });

    }
}