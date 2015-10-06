package com.example.juancho.punto5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


//--------------------------
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.view.View;

import java.util.Calendar;
import java.util.Locale;
//-----------------------------


public class MainActivity extends AppCompatActivity {
    private RadioButton hombre,mujer;
    CheckBox pescar,nadar,trotar,leer;
int contador=0;
//para la fecha de nacimiento
    private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear=1;
    private int mMonth=1;
    private int mDay=1;
    static final int DATE_DIALOG_ID = 0;//para identificar al pickerDialog
    private DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear=year;
            mMonth=monthOfYear;
            mDay=dayOfMonth;
            updateDisplay();
        }
    };
    private void  updateDisplay(){
        mDateDisplay.setText(new StringBuilder().append(mMonth+1).append("-").append(mDay).append("-").append(mYear).append("")   );
    }
//----------------------------
 @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
        }
        return null;

    }

 //-----------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateDisplay=(TextView)findViewById(R.id.Tpick);
        mPickDate=(Button)findViewById(R.id.Bpick);

        mPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
               }
        });
        final Calendar c= Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay= c.get(Calendar.DAY_OF_YEAR);
        updateDisplay();

//------------------------------------------------------
        final EditText nombre = (EditText) findViewById(R.id.INnombre);
        final EditText apellido = (EditText) findViewById(R.id.INapellido);
        final EditText ident = (EditText) findViewById(R.id.INCC);
        final RadioGroup rg= (RadioGroup)findViewById(R.id.rg);

        final TextView NOMout = (TextView ) findViewById(R.id.text1);
        final TextView APEout = (TextView ) findViewById(R.id.text2);
        final TextView CCout = (TextView ) findViewById(R.id.text3);
        final TextView SEXout = (TextView ) findViewById(R.id.text4);
        final TextView CIUout = (TextView ) findViewById(R.id.text5);
        final TextView PASA1 = (TextView ) findViewById(R.id.text6);
        final TextView PASA2 = (TextView ) findViewById(R.id.text7);

        final TextView NOMout2 = (TextView ) findViewById(R.id.text8);
        final TextView APEout2 = (TextView ) findViewById(R.id.text9);
        final TextView CCout2 = (TextView ) findViewById(R.id.text10);
        final TextView SEXout2 = (TextView ) findViewById(R.id.text11);
        final TextView CIUout2 = (TextView ) findViewById(R.id.text12);
        final TextView PASA12 = (TextView ) findViewById(R.id.text13);
        final TextView PASA22 = (TextView ) findViewById(R.id.text14);

        final TextView NOMout3 = (TextView ) findViewById(R.id.text15);
        final TextView APEout3 = (TextView ) findViewById(R.id.text16);
        final TextView CCout3 = (TextView ) findViewById(R.id.text17);
        final TextView SEXout3 = (TextView ) findViewById(R.id.text18);
        final TextView CIUout3 = (TextView ) findViewById(R.id.text19);
        final TextView PASA13 = (TextView ) findViewById(R.id.text20);
        final TextView PASA23 = (TextView ) findViewById(R.id.text21);



        leer = (CheckBox) findViewById(R.id.Cleer);
        trotar = (CheckBox) findViewById(R.id.CTrotar);
        nadar = (CheckBox) findViewById(R.id.Cnadar);
        pescar = (CheckBox) findViewById(R.id.Cpescar);

        final Spinner lista = (Spinner) findViewById(R.id.INciudades);
        Button Load = (Button) findViewById(R.id.boton);

        hombre = (RadioButton)findViewById(R.id.RBH);
        mujer= (RadioButton)findViewById(R.id.RBF);

        rg.clearCheck();// desmarcar opciones
        rg.check(R.id.RBH);//marcar una opcion segun id
 //---------------------------------------------------------
Load.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(contador%3==0){
       NOMout.setText("Nombre: "+nombre.getText());
       APEout.setText("Apellido: "+apellido.getText());
       CCout.setText("CC: "+ident.getText());
       if (hombre.isChecked()) SEXout.setText("Sexo: Masculino");
       else if(mujer.isChecked()) SEXout.setText("Sexo: Femenino");
       CIUout.setText("Ciudad de Nacimiento: "+lista.getSelectedItem().toString());
       PASA1.setText("Fecha de Nacimiento: " + (mMonth + 1) + " / " + mDay + " / " + mYear);
       String aux1,aux2,aux3,aux4;
        if(leer.isChecked())aux1="Leer";
        else aux1="";
        if(trotar.isChecked())aux2="Trotar";
        else aux2="";
        if(nadar.isChecked())aux3="Nadar";
        else aux3="";
        if(pescar.isChecked())aux4="Pescar";
        else aux4="";
        PASA2.setText("Hobbie(s): "+aux1+" "+aux2+" "+aux3+" "+aux4);}
        if(contador%3==1){
            NOMout2.setText("Nombre: "+nombre.getText());
            APEout2.setText("Apellido: "+apellido.getText());
            CCout2.setText("CC: "+ident.getText());
            if (hombre.isChecked()) SEXout2.setText("Sexo: Masculino");
            else if(mujer.isChecked()) SEXout2.setText("Sexo: Femenino");
            CIUout2.setText("Ciudad de Nacimiento: "+lista.getSelectedItem().toString());
            PASA12.setText("Fecha de Nacimiento: " + (mMonth + 1) + " / " + mDay + " / " + mYear);
            String aux1,aux2,aux3,aux4;
            if(leer.isChecked())aux1="Leer";
            else aux1="";
            if(trotar.isChecked())aux2="Trotar";
            else aux2="";
            if(nadar.isChecked())aux3="Nadar";
            else aux3="";
            if(pescar.isChecked())aux4="Pescar";
            else aux4="";
            PASA22.setText("Hobbie(s): "+aux1+" "+aux2+" "+aux3+" "+aux4);}
        if(contador%3==2){
            NOMout3.setText("Nombre: "+nombre.getText());
            APEout3.setText("Apellido: "+apellido.getText());
            CCout3.setText("CC: "+ident.getText());
            if (hombre.isChecked()) SEXout3.setText("Sexo: Masculino");
            else if(mujer.isChecked()) SEXout3.setText("Sexo: Femenino");
            CIUout3.setText("Ciudad de Nacimiento: "+lista.getSelectedItem().toString());
            PASA13.setText("Fecha de Nacimiento: " + (mMonth + 1) + " / " + mDay + " / " + mYear);
            String aux1,aux2,aux3,aux4;
            if(leer.isChecked())aux1="Leer";
            else aux1="";
            if(trotar.isChecked())aux2="Trotar";
            else aux2="";
            if(nadar.isChecked())aux3="Nadar";
            else aux3="";
            if(pescar.isChecked())aux4="Pescar";
            else aux4="";
            PASA23.setText("Hobbie(s): "+aux1+" "+aux2+" "+aux3+" "+aux4);}

       contador++;
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
