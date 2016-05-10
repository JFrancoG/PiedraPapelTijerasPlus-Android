package com.games.apps.drpuerk.piedrapapeltijerasplus;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity  {

    private Button btnEntrar;
    private Usuario user;
    private MediaPlayer mp;
    private int densidad;
    private double pulgadas;
    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        densidad = getResources().getDisplayMetrics().densityDpi;
        pulgadas = Imagen.calcularPulgadas(size.x,size.y,densidad);
        System.out.println("-------- pulgadas --------"+pulgadas);
        if(pulgadas >= 7)
            isTablet = true;
        else
            isTablet = false;

        user = new Usuario();
        user.setNick(getResources().getString(R.string.strNickDefecto));
        user.setDensidad(densidad);
        user.setTablet(isTablet);

        mp = MediaPlayer.create(MainActivity.this, R.raw.pelot);
        mp.start();

        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        porArriba(btnEntrar);

    }

    public void pulsaEntrar(View v)
    {
        Intent intMod = new Intent(MainActivity.this, Modalidad.class);
        intMod.putExtra("USER",user);
        startActivity(intMod);
    }

    public void porArriba(Button btn)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.arriba);
        btn.startAnimation(a);
    }
/*
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
    }*/
}

