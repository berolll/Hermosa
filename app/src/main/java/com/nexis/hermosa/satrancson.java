package com.nexis.hermosa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class satrancson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satrancson);
        AlertDialog.Builder builder = new AlertDialog.Builder(satrancson.this);
        builder.setTitle("");
        builder.setMessage("Etkinliğe kaydınız oluşturulmuştur");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(satrancson.this);
                builder.setTitle("BİLGİ");
                builder.setMessage("Etkinlik Bilgilerini Mail ile Gönder?");
                builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent gelenIntent=getIntent();
                        String[] kisia={gelenIntent.getStringExtra("kisimail")};
                        sendmail(kisia,"ETKİNLİK BİLGİLENDİRME","---SATRANÇ TURNUVASI---\n"+
                                "Adres : Merkez, Reşit Paşa Cd. No:63, 34310 Avcılar/İstanbul\n"+
                                "Tarih : 14.05.2022\n"+
                                "Saat : 08.00");
                    }
                });
                builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Intent intent=new Intent(satrancson.this,Etkinlik2.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        builder.show();

    }
    private void sendmail(String[] eMail,String konu,String mesaj){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_EMAIL,eMail);
        intent.putExtra(intent.EXTRA_SUBJECT,konu);
        intent.putExtra(intent.EXTRA_TEXT,mesaj);
        intent.setType("message/rfc822");
        startActivity(intent);


        AlertDialog.Builder builder1 = new AlertDialog.Builder(satrancson.this);
        builder1.setTitle("BİLGİ");
        builder1.setMessage("Etkinlik  Bilgileri  Mailinize  Gönderilmiştir...");
        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder builder = new AlertDialog.Builder(satrancson.this);
                builder1.setTitle("BİLGİ");
                builder1.setMessage(" Uygulamadan çıkış yapmak ister misiniz");
                builder1.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);





                    }
                });
                builder1.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(satrancson.this,MapsActivity.class);
                        startActivity(intent);
                    }
                });
                builder1.show();
            }
        });

        builder1.show();





    }
}