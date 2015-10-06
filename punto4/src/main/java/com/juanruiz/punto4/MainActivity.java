package com.juanruiz.punto4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//Variable Global
    int ope=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Estableciendo referencias

        final RadioGroup rg=(RadioGroup) findViewById(R.id.GrbGrupo1);
        final TextView Var1_OUT=(TextView)findViewById(R.id.OUT1);
        final TextView Var2_OUT=(TextView)findViewById(R.id.OUT2);
        final EditText Var1_IN=(EditText)findViewById(R.id.IN1);
        final EditText Var2_IN=(EditText)findViewById(R.id.IN2);
        Button boton=(Button)findViewById(R.id.boton);
        final TextView area=(TextView)findViewById(R.id.area);

        //Reestableciendo radio grupo
        rg.clearCheck();
        Var1_OUT.setVisibility(View.INVISIBLE);
        Var1_IN.setVisibility(View.INVISIBLE);
        Var2_OUT.setVisibility(View.INVISIBLE);
        Var2_IN.setVisibility(View.INVISIBLE);
        //cuando se da click sobre un CB
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.RBcuadrado:{
                        ope=0;
                        Var1_OUT.setVisibility(View.VISIBLE);
                        Var1_IN.setVisibility(View.VISIBLE);
                        Var1_OUT.setText("Longitud Lado: ");
                        Var1_IN.setHint("Ingrese Valor");
                        Var2_OUT.setVisibility(View.INVISIBLE);
                        Var2_IN.setVisibility(View.INVISIBLE);
                        break;
                    }
                    case R.id.RBrectangulo:{
                        ope=1;
                        Var1_OUT.setVisibility(View.VISIBLE);
                        Var1_IN.setVisibility(View.VISIBLE);
                        Var1_OUT.setText("Lado 1: ");
                        Var1_IN.setHint("Ingrese Valor");
                        Var2_OUT.setVisibility(View.VISIBLE);
                        Var2_IN.setVisibility(View.VISIBLE);
                        Var2_OUT.setText("Lado 2: ");
                        Var1_IN.setHint("Ingrese Valor");
                        break;
                    }
                    case R.id.RBtriangulo:{
                        ope=2;
                        Var1_OUT.setVisibility(View.VISIBLE);
                        Var1_IN.setVisibility(View.VISIBLE);
                        Var1_OUT.setText("Altura : ");
                        Var1_IN.setHint("Ingrese Valor");
                        Var2_OUT.setVisibility(View.VISIBLE);
                        Var2_IN.setVisibility(View.VISIBLE);
                        Var2_OUT.setText("Base   : ");
                        Var1_IN.setHint("Ingrese Valor");
                        break;
                    }
                    case R.id.RBcirculo:{
                        ope=3;
                        Var1_OUT.setVisibility(View.VISIBLE);
                        Var1_IN.setVisibility(View.VISIBLE);
                        Var1_OUT.setText("Radio: ");
                        Var1_IN.setHint("Ingrese Valor");
                        Var2_OUT.setVisibility(View.INVISIBLE);
                        Var2_IN.setVisibility(View.INVISIBLE);
                        break;
                    }
                }
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total=0,aux1=0,aux2=0;
                String NUM1=Var1_IN.getText().toString();
                String NUM2=Var2_IN.getText().toString();

                switch (ope){
                    case 0:{
                        if(TextUtils.isEmpty(NUM1)){
                            Var1_IN.setError("Error");
                        }
                        else{
                            aux1=Double.parseDouble(Var1_IN.getText().toString());
                            total=aux1*aux1;
                            area.setText("Area= "+String.valueOf(String.format("%.2f", total)));
                            Var1_IN.getEditableText().clear();

                        }

                        break;
                    }
                    case 1:{
                        if(TextUtils.isEmpty(NUM1)||TextUtils.isEmpty(NUM2)){
                            if(TextUtils.isEmpty(NUM1)){
                                Var1_IN.setError("Error");
                            }
                            if(TextUtils.isEmpty(NUM2)){
                                Var2_IN.setError("Error");
                            }

                        }
                        else{
                            aux1=Double.parseDouble(Var1_IN.getText().toString());
                            aux2=Double.parseDouble(Var2_IN.getText().toString());
                            total=aux1*aux2;
                            area.setText("Area= "+String.valueOf(String.format("%.2f",total)));
                            Var1_IN.getEditableText().clear();
                            Var2_IN.getEditableText().clear();
                        }
                        break;
                    }
                    case 2:{
                        if(TextUtils.isEmpty(NUM1)||TextUtils.isEmpty(NUM2)){
                            if(TextUtils.isEmpty(NUM1)){
                                Var1_IN.setError("Error");
                            }
                            if(TextUtils.isEmpty(NUM2)){
                                Var2_IN.setError("Error");
                            }

                        }
                        else{
                            aux1=Double.parseDouble(Var1_IN.getText().toString());
                            aux2=Double.parseDouble(Var2_IN.getText().toString());
                            total=(aux1*aux2)/2;
                            area.setText("Area= "+String.valueOf(String.format("%.2f",total)));
                            Var1_IN.getEditableText().clear();
                            Var2_IN.getEditableText().clear();

                        }
                        break;
                    }
                    case 3:{
                        if(TextUtils.isEmpty(NUM1)){
                            Var1_IN.setError("Error");
                        }
                        else{
                            aux1=Double.parseDouble(Var1_IN.getText().toString());
                            total=(aux1*aux1)*3.1416;
                            area.setText("Area= "+String.valueOf(String.format("%.2f",total)));
                            Var1_IN.getEditableText().clear();


                        }
                        break;
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
