package com.nexis.hermosa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mackayit extends AppCompatActivity {
    private EditText edittxtad;
    private EditText edittxtsoyad;
    private EditText txtmaila;
    private Button btnkayit;
    private String valid_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mackayit);
        edittxtad = (EditText) findViewById(R.id.edittxtad);
        edittxtsoyad = (EditText) findViewById(R.id.edittxtsoyad);
        txtmaila=(EditText)findViewById(R.id.txtmaila);
        btnkayit = (Button) findViewById(R.id.btnkayit);
        txtmaila.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

            }




            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                // TODO Auto-generated method stub
                Is_Valid_Email(txtmaila); // pass your EditText Obj here.
            }

            public void Is_Valid_Email(EditText edt) {
                if (edt.getText().toString() == null) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else if (isEmailValid(edt.getText().toString()) == false) {
                    edt.setError("Invalid Email Address");
                    valid_email = null;
                } else {
                    valid_email = edt.getText().toString();
                }
            }

            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                        .matches();
            } // end of TextWatcher (email)
        });

        btnkayit.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                String mai = txtmaila.getText().toString();
                if (!TextUtils.isEmpty(mai)) {
                    Intent intent = new Intent(mackayit.this, macson.class);
                    intent.putExtra("kisimail",mai);

                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mackayit.this);
                    builder.setTitle("HATA ");
                    builder.setMessage("mail adresi boş bırakılamaz!");
                    builder.setPositiveButton("Tamam",null);
                    builder.show();

                }
            }
        });
    }
}