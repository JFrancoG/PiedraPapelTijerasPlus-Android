package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class Modalidad extends Activity {

    private ImageButton btnAjustes;
    private Button btnBasico,btnBigBang,btn9opt,btn15opt;
    private Usuario user;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_modalidad);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnAjustes = (ImageButton)findViewById(R.id.btnAjustes);

        btnBasico = (Button) findViewById(R.id.btnBasico);
        btnBigBang = (Button) findViewById(R.id.btnBigBang);
        btn9opt = (Button) findViewById(R.id.btn9opt);
        btn15opt = (Button) findViewById(R.id.btn15opt);

        porDerecha(btnAjustes);
        porIzquierda(btnBasico);
        aparecer(btn9opt);
        aparecer(btnBigBang);
        porIzquierda(btn15opt);

        mp = MediaPlayer.create(Modalidad.this, R.raw.pelot);
        mp.start();
    }

    public void pulsaAjustes(View v)
    {
        mp = MediaPlayer.create(Modalidad.this, R.raw.toc);
        mp.start();
        Intent intAjuste = new Intent(Modalidad.this, Ajustes.class);
        intAjuste.putExtra("USER", user);
        startActivity(intAjuste);
    }

    public void pulsaBasico(View v)
    {
        mp = MediaPlayer.create(Modalidad.this, R.raw.toc);
        mp.start();
        Intent intSubMenu = new Intent(Modalidad.this, SubMenuClasico.class);
        intSubMenu.putExtra("USER", user);
        startActivity(intSubMenu);
    }

    public void pulsaBigBang(View v)
    {
        mp = MediaPlayer.create(Modalidad.this, R.raw.toc);
        mp.start();
        Intent intSubMenu = new Intent(Modalidad.this, SubMenuBigBang.class);
        intSubMenu.putExtra("USER", user);
        startActivity(intSubMenu);
    }

    public void pulsa9opt(View v)
    {
        mp = MediaPlayer.create(Modalidad.this, R.raw.toc);
        mp.start();
        Intent intSubMenu = new Intent(Modalidad.this, SubMenu9opt.class);
        intSubMenu.putExtra("USER", user);
        startActivity(intSubMenu);
    }

    public void pulsa15opt(View v)
    {
        mp = MediaPlayer.create(Modalidad.this, R.raw.toc);
        mp.start();
        Intent intSubMenu = new Intent(Modalidad.this, SubMenu15opt.class);
        intSubMenu.putExtra("USER", user);
        startActivity(intSubMenu);
    }

    public void aparecer(Button btn)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.aparicion);
        btn.startAnimation(a);
    }

    public void porIzquierda(Button btn)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.izquierda);
        btn.startAnimation(a);
    }

    public void porDerecha(ImageButton btn)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.derecha);
        btn.startAnimation(a);
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modalidad, menu);
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
