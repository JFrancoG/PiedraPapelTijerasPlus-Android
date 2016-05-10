package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import java.util.Locale;

/**
 * Created by root on 10/12/15.
 */
public class Ajustes extends Activity {

    private ImageButton btnSpain,btnEngland;
    private Usuario user;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnSpain = (ImageButton)findViewById(R.id.btnSpain);
        btnEngland = (ImageButton)findViewById(R.id.btnEngland);

    }

    public void pulsaVolver(View v){
        mp = MediaPlayer.create(Ajustes.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intMod = new Intent(Ajustes.this, Modalidad.class);
        intMod.putExtra("USER",user);
        startActivity(intMod);
    }

    public void pulsaSpain(View v){
        mp = MediaPlayer.create(Ajustes.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        cambiarIdioma("es");
        if(user.getNick().compareToIgnoreCase("GUEST") == 0)
            user.setNick("INVITADO");
        Intent intMod = new Intent(Ajustes.this, Modalidad.class);
        intMod.putExtra("USER",user);
        startActivity(intMod);
    }

    public void pulsaEngland(View v){
        mp = MediaPlayer.create(Ajustes.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        cambiarIdioma("en");
        if(user.getNick().compareToIgnoreCase("INVITADO") == 0)
            user.setNick("GUEST");
        Intent intMod = new Intent(Ajustes.this, Modalidad.class);
        intMod.putExtra("USER",user);
        startActivity(intMod);
    }

    public void pulsaPerfil(View v){
        mp = MediaPlayer.create(Ajustes.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intReg = new Intent(Ajustes.this, Registro.class);
        intReg.putExtra("USER", user);
        startActivity(intReg);
    }

    public void cambiarIdioma(String idioma)
    {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(idioma);
        res.updateConfiguration(conf, dm);
        //finish();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajustes, menu);
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
    }*/
}
