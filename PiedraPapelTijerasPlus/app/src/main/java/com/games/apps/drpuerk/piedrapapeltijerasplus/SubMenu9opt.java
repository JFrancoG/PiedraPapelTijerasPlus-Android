package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class SubMenu9opt extends Activity {

    private ImageButton btnPiedra,btnPapel,btnTijeras,btnEsponja,btnAire,btnAgua,btnHumano,btnFuego,btnPistola;
    private Usuario user;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu9opt);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnPiedra = (ImageButton)findViewById(R.id.btnPiedra9opt);
        btnPapel = (ImageButton)findViewById(R.id.btnPapel9opt);
        btnTijeras = (ImageButton)findViewById(R.id.btnTijeras9opt);
        btnEsponja = (ImageButton)findViewById(R.id.btnEsponja9opt);
        btnAire = (ImageButton)findViewById(R.id.btnAire9opt);
        btnAgua = (ImageButton)findViewById(R.id.btnAgua9opt);
        btnHumano = (ImageButton)findViewById(R.id.btnHumano9opt);
        btnFuego = (ImageButton)findViewById(R.id.btnFuego9opt);
        btnPistola = (ImageButton)findViewById(R.id.btnPistola9opt);
    }

    public void pulsaPiedra(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPiedra.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPiedra);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaPapel(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPapel.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPapel);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaTijeras(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnTijeras.startAnimation(anim);
        String cadena = getResources().getString(R.string.strTijeras);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaEsponja(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnEsponja.startAnimation(anim);
        String cadena = getResources().getString(R.string.strEsponja);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaAire(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnAire.startAnimation(anim);
        String cadena = getResources().getString(R.string.strAire);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaAgua(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnAgua.startAnimation(anim);
        String cadena = getResources().getString(R.string.strAgua);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaHumano(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnHumano.startAnimation(anim);
        String cadena = getResources().getString(R.string.strHumano);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaFuego(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnFuego.startAnimation(anim);
        String cadena = getResources().getString(R.string.strFuego);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaPistola(View v)
    {
        mp = MediaPlayer.create(SubMenu9opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPistola.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPistola);
        Intent intent = new Intent(SubMenu9opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 9);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_menu9opt, menu);
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
