package com.juanruiz.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Establecer las referencias
        final EditText Quicez= (EditText) findViewById(R.id.Quices);
        final EditText Expo= (EditText)findViewById(R.id.Expo);
        final EditText Lab= (EditText) findViewById(R.id.Lab);
        final EditText Proy= (EditText)findViewById(R.id.Proy);
        Button Load= (Button)findViewById(R.id.boton);
        final TextView nota= (TextView)findViewById(R.id.resultado);


        Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double quiz=0,expo=0, proy=0, lab=0, total=0;
                String QUIZ=Quicez.getText().toString();
                String EXPO=Expo.getText().toString();
                String PROY=Proy.getText().toString();
                String LAB=Lab.getText().toString();
                Boolean flag=false;
                nota.setText(" ");

                if(TextUtils.isEmpty(QUIZ) || TextUtils.isEmpty(EXPO)|| TextUtils.isEmpty(PROY)|| TextUtils.isEmpty(LAB) ){
                    if(TextUtils.isEmpty(QUIZ)){
                        Quicez.setError("Error");
                    }
                    if(TextUtils.isEmpty(EXPO)){
                        Expo.setError("Error");
                    }
                    if(TextUtils.isEmpty(PROY)){
                        Proy.setError("Error");
                    }
                    if(TextUtils.isEmpty(LAB)){
                        Lab.setError("Error");
                    }
                }
                else {

                    flag=false;
                    quiz=Double.parseDouble(Quicez.getText().toString());
                    proy=Double.parseDouble(Proy.getText().toString());
                    lab=Double.parseDouble(Lab.getText().toString());
                    expo=Double.parseDouble(Expo.getText().toString());

                    if(quiz<0.0 || quiz>5.0){Quicez.setError("Fuera de Rango");flag=true;}
                    if(proy<0.0 || proy>5.0){Proy.setError("Fuera de Rango");flag=true;}
                    if(lab<0.0 || lab>5.0){Lab.setError("Fuera de Rango");flag=true;}
                    if(expo<0.0 || expo>5.0){Expo.setError("Fuera de Rango");flag=true;}

                    if(flag==false){
                        total=(quiz*0.15)+(proy*0.35)+(lab*0.4)+(expo*0.1);
                        if(total>=3){nota.setText(""+String.valueOf(String.format("%.2f",total))+" :) "); }
                        else{ nota.setText(""+String.valueOf(String.format("%.2f",total))+" :( ");}

                    }

                }





            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
