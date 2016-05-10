package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class SubMenu15opt extends Activity {

    private ImageButton btnPiedra,btnPapel,btnTijeras,btnFuego,btnArbol,btnAire,btnAgua,btnHumano;
    private ImageButton btnPistola,btnSerpiente,btnEsponja,btnDragon,btnDiablo,btnRayo,btnLobo;
    private Usuario user;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu15opt);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnPiedra = (ImageButton)findViewById(R.id.btnPiedra15opt);
        btnPapel = (ImageButton)findViewById(R.id.btnPapel15opt);
        btnTijeras = (ImageButton)findViewById(R.id.btnTijeras15opt);
        btnFuego = (ImageButton)findViewById(R.id.btnFuego15opt);
        btnArbol = (ImageButton)findViewById(R.id.btnArbol15opt);
        btnAire = (ImageButton)findViewById(R.id.btnAire15opt);
        btnAgua = (ImageButton)findViewById(R.id.btnAgua15opt);
        btnHumano = (ImageButton)findViewById(R.id.btnHumano15opt);
        btnPistola = (ImageButton)findViewById(R.id.btnPistola15opt);
        btnSerpiente = (ImageButton)findViewById(R.id.btnSerpiente15opt);
        btnEsponja = (ImageButton)findViewById(R.id.btnEsponja15opt);
        btnDragon = (ImageButton)findViewById(R.id.btnDragon15opt);
        btnDiablo = (ImageButton)findViewById(R.id.btnDiablo15opt);
        btnRayo = (ImageButton)findViewById(R.id.btnRayo15opt);
        btnLobo = (ImageButton)findViewById(R.id.btnLobo15opt);
    }

    public void pulsaPiedra(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPiedra.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPiedra);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaPapel(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPapel.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPapel);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaTijeras(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnTijeras.startAnimation(anim);
        String cadena = getResources().getString(R.string.strTijeras);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaFuego(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnFuego.startAnimation(anim);
        String cadena = getResources().getString(R.string.strFuego);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaArbol(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnArbol.startAnimation(anim);
        String cadena = getResources().getString(R.string.strArbol);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaAire(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnAire.startAnimation(anim);
        String cadena = getResources().getString(R.string.strAire);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaAgua(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnAgua.startAnimation(anim);
        String cadena = getResources().getString(R.string.strAgua);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaHumano(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnHumano.startAnimation(anim);
        String cadena = getResources().getString(R.string.strHumano);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaPistola(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPistola.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPistola);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaSerpiente(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnSerpiente.startAnimation(anim);
        String cadena = getResources().getString(R.string.strSerpiente);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaEsponja(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnEsponja.startAnimation(anim);
        String cadena = getResources().getString(R.string.strEsponja);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaDragon(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnDragon.startAnimation(anim);
        String cadena = getResources().getString(R.string.strDragon);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaDiablo(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnDiablo.startAnimation(anim);
        String cadena = getResources().getString(R.string.strDiablo);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaRayo(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnRayo.startAnimation(anim);
        String cadena = getResources().getString(R.string.strRayo);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaLobo(View v)
    {
        mp = MediaPlayer.create(SubMenu15opt.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnLobo.startAnimation(anim);
        String cadena = getResources().getString(R.string.strLobo);
        Intent intent = new Intent(SubMenu15opt.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 15);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_menu15opt, menu);
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

