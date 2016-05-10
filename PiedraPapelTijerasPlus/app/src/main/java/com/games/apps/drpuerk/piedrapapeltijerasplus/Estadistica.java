package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Estadistica extends Activity {

    private final int TAM_BASE_IMG = 58;
    private final int TAM_BASE_CIRC = 64;

    private Usuario user;
    private int modo;
    private MediaPlayer mp;
    private ImageView ivFoto,ivCirculo,ivFotot,ivCirculot;
    private ImageButton btnAjustesEst;
    private Button btnEmpezar, btnCambiarModo;
    private int densidad;
    private boolean isTablet;
    private TextView tvNick, tvPorcGan, tvPorcPerd, tvPorcTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        Bundle bundle = getIntent().getExtras();
        modo = bundle.getInt("MODO");
        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        btnCambiarModo = (Button) findViewById(R.id.btnCambiarModo);
        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);
        btnAjustesEst = (ImageButton)findViewById(R.id.btnAjustesEst);

        densidad = user.getDensidad();
        isTablet = user.getTablet();

        tvNick = (TextView)findViewById(R.id.tvNick);
        tvNick.setText(user.getNick());

        tvPorcGan = (TextView)findViewById(R.id.tvPorcGan);
        tvPorcPerd = (TextView)findViewById(R.id.tvPorcPerd);
        tvPorcTab = (TextView)findViewById(R.id.tvPorcTab);

        double jugadas = user.getGanadas()+user.getPerdidas()+user.getTablas();
        double porcGan = 0, porcPerd = 0, porcTab = 0;
        DecimalFormat f = new DecimalFormat("##.##%");

        porcGan = user.getGanadas() / jugadas;
        porcPerd = user.getPerdidas() / jugadas;
        porcTab= user.getTablas() / jugadas;

        tvPorcGan.setText(user.getGanadas() + ".   " + f.format(porcGan));
        tvPorcPerd.setText(user.getPerdidas() + ".   " + f.format(porcPerd));
        tvPorcTab.setText(user.getTablas() + ".   " + f.format(porcTab));

        if(!isTablet){
            ivFoto = (ImageView)findViewById(R.id.ivfotoestad);
            ivCirculo = (ImageView)findViewById(R.id.ivCirculoEst);
        }

        else{
            ivFotot = (ImageView)findViewById(R.id.ivfotoestadt);
            ivCirculot = (ImageView)findViewById(R.id.ivCirculoEstt);
        }

        String ruta = user.getRuta();
        if (ruta != null){
            desactivarBotones();
            if(!isTablet){
                new HiloCargaImagen(false, null, 1, ruta, ivFoto, densidad, isTablet, TAM_BASE_IMG).execute();
                ivCirculo.setAdjustViewBounds(true);
                ivCirculo.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculo.setImageResource(R.drawable.circulog);
            }
            else{
                new HiloCargaImagen(false, null, 1, ruta, ivFotot, densidad, isTablet, TAM_BASE_IMG).execute();
                ivCirculot.setAdjustViewBounds(true);
                ivCirculot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculot.setImageResource(R.drawable.circulogt);
            }
            activarBotones();
        }
    }

    private void activarBotones() {
        btnCambiarModo.setEnabled(true);
        btnEmpezar.setEnabled(true);
        btnAjustesEst.setEnabled(true);
    }

    private void desactivarBotones() {
        btnCambiarModo.setEnabled(false);
        btnEmpezar.setEnabled(false);
        btnAjustesEst.setEnabled(false);
    }

    public void pulsaAjustesE(View v)
    {
        mp = MediaPlayer.create(Estadistica.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intAjuste = new Intent(Estadistica.this, Ajustes.class);
        intAjuste.putExtra("USER", user);
        startActivity(intAjuste);
    }

    public void pulsaCambiarModo (View v){
        mp = MediaPlayer.create(Estadistica.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intMod = new Intent(Estadistica.this, Modalidad.class);
        intMod.putExtra("USER", user);
        startActivity(intMod);
    }
    public void pulsaEmpezar (View v) {
        mp = MediaPlayer.create(Estadistica.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intEmp = null;
        switch (modo){
            case 3: intEmp = new Intent(Estadistica.this, SubMenuClasico.class);
                break;
            case 5: intEmp = new Intent(Estadistica.this, SubMenuBigBang.class);
                break;
            case 9: intEmp = new Intent(Estadistica.this, SubMenu9opt.class);
                break;
            case 15: intEmp = new Intent(Estadistica.this, SubMenu15opt.class);
        }
        intEmp.putExtra("USER", user);
        startActivity(intEmp);
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estadistica, menu);
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
