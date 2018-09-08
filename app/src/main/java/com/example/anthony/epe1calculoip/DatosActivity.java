package com.example.anthony.epe1calculoip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * Calculo ipchile
 *
 * Copyright (C) 2018 DesApli
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 *
 */

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtNom;
    EditText txtApe;
    EditText txtCor;
    TextView btnIng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        txtNom = (EditText) findViewById(R.id.txtNom);
        txtApe = (EditText) findViewById(R.id.txtApe);
        txtCor = (EditText) findViewById(R.id.txtCor);
        btnIng = (TextView) findViewById(R.id.btnIngresar);
        btnIng.setOnClickListener(this);

        txtNom.setText("");
        txtApe.setText("");
        txtCor.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==findViewById(R.id.btnIngresar).getId()){
            String nom = txtNom.getText().toString();
            String ape = txtApe.getText().toString();
            String cor = txtCor.getText().toString();
            if(nom.equals("") || ape.equals("") || cor.equals("")){
                Toast.makeText(this, "COMPLETA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }else{
                Bundle b = new Bundle();
                String datos[]={nom,ape,cor};
                b.putStringArray("datos", datos);
                Intent in =new Intent();
                in.setClass(getApplicationContext(),MainActivity.class);
                in.putExtras(b);
                startActivity(in);
            }
        }
    }
}
