package com.juanruiz.punto2;

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

public class punto2 extends AppCompatActivity {
// Variables globales
    int ope=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);
// se establecen las referencias
        final RadioGroup rg = (RadioGroup)findViewById(R.id.GrbGrupo1);
         Button Cargar=(Button) findViewById(R.id.Bcalcular);
        final TextView result=(TextView)findViewById(R.id.resultado);
        final EditText num1=(EditText) findViewById(R.id.num1);
        final EditText num2=(EditText) findViewById(R.id.num2);
//INicializar con el button suma activado
        rg.clearCheck();// desmarcar opciones
        rg.check(R.id.RBsuma);//marcar una opcion segun id

//        int idSeleccionado = rg.getCheckedRadioButtonId(); // saber el seleccionado
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//chequear cual
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
             String opcion="";
                switch(checkedId){
                    case R.id.RBsuma:
                       // opcion="suma";
                        ope=0;
                    break;
                    case R.id.RBrestar:
                       // opcion="restar";
                        ope=1;
                        break;
                    case R.id.RBmulti:
                       // opcion="mult";
                        ope=2;
                        break;
                    case R.id.RBdivi:
                        //opcion="div";
                        ope=3;
                        break;
                }
                //result.setText("Opcion: "+String.valueOf(ope));

           }
         });

        Cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numero1=0,numero2=0, total=0;
                String NUM1=num1.getText().toString();
                String NUM2=num2.getText().toString();
                result.setText(" ");
                if(TextUtils.isEmpty(NUM1) || TextUtils.isEmpty(NUM2) ){
                    if(TextUtils.isEmpty(NUM1)){
                    num1.setError("Error");
                    }
                    if(TextUtils.isEmpty(NUM2)){
                        num2.setError("Error");
                        }
                }
                else{

                        numero1=Double.parseDouble(num1.getText().toString());
                        numero2=Double.parseDouble(num2.getText().toString());

                        if(numero2==0.0 && ope==3){

                            result.setText("Error..!");
                            num2.setError("Error");
                        }
                        else {
                            switch (ope) {
                                case 0:
                                    total = numero1 + numero2;
                                    break;
                                case 1:
                                    total = numero1 - numero2;
                                    break;
                                case 2:
                                    total = numero1 * numero2;
                                    break;
                                case 3:
                                    total = numero1 / numero2;
                                    break;
                            }

                            result.setText(String.valueOf(String.format("%.3f",total)));
                            num1.getEditableText().clear();
                            num2.getEditableText().clear();
                        }





                }

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto2, menu);
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
