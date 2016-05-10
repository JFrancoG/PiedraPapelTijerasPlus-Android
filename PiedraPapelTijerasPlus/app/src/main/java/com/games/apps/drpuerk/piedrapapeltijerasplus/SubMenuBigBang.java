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

public class SubMenuBigBang extends Activity {

    private ImageButton btnPiedra,btnPapel,btnTijeras,btnLagarto,btnSpock;
    private Usuario user;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu_big_bang);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnPiedra = (ImageButton)findViewById(R.id.btnPiedra5opt);
        btnPapel = (ImageButton)findViewById(R.id.btnPapel5opt);
        btnTijeras = (ImageButton)findViewById(R.id.btnTijeras5opt);
        btnLagarto = (ImageButton)findViewById(R.id.btnLagarto5opt);
        btnSpock = (ImageButton)findViewById(R.id.btnSpock5opt);
    }

    public void pulsaPiedra(View v)
    {
        mp = MediaPlayer.create(SubMenuBigBang.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPiedra.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPiedra);
        Intent intent = new Intent(SubMenuBigBang.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 5);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaPapel(View v)
    {
        mp = MediaPlayer.create(SubMenuBigBang.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnPapel.startAnimation(anim);
        String cadena = getResources().getString(R.string.strPapel);
        Intent intent = new Intent(SubMenuBigBang.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 5);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaTijeras(View v)
    {
        mp = MediaPlayer.create(SubMenuBigBang.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnTijeras.startAnimation(anim);
        String cadena = getResources().getString(R.string.strTijeras);
        Intent intent = new Intent(SubMenuBigBang.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 5);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaLagarto(View v)
    {
        mp = MediaPlayer.create(SubMenuBigBang.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnLagarto.startAnimation(anim);
        String cadena = getResources().getString(R.string.strLagarto);
        Intent intent = new Intent(SubMenuBigBang.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 5);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void pulsaSpock(View v)
    {
        mp = MediaPlayer.create(SubMenuBigBang.this, R.raw.toc);
        mp.start();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        btnSpock.startAnimation(anim);
        String cadena = getResources().getString(R.string.strSpock);
        Intent intent = new Intent(SubMenuBigBang.this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("TEXT",cadena);
        bundle.putInt("MODO", 5);
        intent.putExtras(bundle);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_menu_big_bang, menu);
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
