package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by root on 10/12/15.
 */
public class Resultado extends Activity {

    private final int TAM_BASE_IMG = 42;
    private final int TAM_BASE_CIRC = 48;
    private static final int MODO3 = 3;
    private static final int MODO5 = 5;
    private static final int MODO9 = 9;
    private static final int MODO15 = 15;
    private static final int TABLAS = 0;
    private static final int GANAR = 1;
    private static final int PERDER = -1;

    private Usuario user;
    private String[] arrOpciones, arrResultados, arrAcciones;
    private int modo;
    private MediaPlayer mp;

    private TextView tvNombre, tvUserRes, tvAndroidRes, tvAccion, tvResultado;
    private ImageButton btnAjustesRes;
    private Button btnCambiarModo, btnEmpezar, btnEstadisticas;
    private int densidad;
    private boolean isTablet;
    private ImageView ivPerson,ivAndroid,ivCirculo,ivCirculoAnd,ivPersonEl,ivAndroidEl;
    private ImageView ivPersont,ivAndroidt,ivCirculot,ivCirculoAndt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");
        Bundle bundle = getIntent().getExtras();
        String eleccion = bundle.getString("TEXT");
        modo = bundle.getInt("MODO");

        densidad = user.getDensidad();
        isTablet = user.getTablet();

        btnCambiarModo = (Button) findViewById(R.id.btnCambiarModo);
        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);
        btnEstadisticas = (Button) findViewById(R.id.btnEstadisticas);
        btnAjustesRes = (ImageButton)findViewById(R.id.btnAjustesRes);

        tvNombre = (TextView)findViewById(R.id.tvTu);
        tvNombre.setText(user.getNick());

        ivPersonEl = (ImageView)findViewById(R.id.ivPersonEleccion);
        ivAndroidEl = (ImageView)findViewById(R.id.ivAndroidEleccion);

        if(!isTablet){
            ivPerson = (ImageView)findViewById(R.id.ivPerson);
            ivCirculo = (ImageView)findViewById(R.id.ivCirculo);
            ivAndroid = (ImageView)findViewById(R.id.ivAndroid);
            ivCirculoAnd = (ImageView)findViewById(R.id.ivCirculoAnd);
        }
        else{
            ivPersont = (ImageView)findViewById(R.id.ivPersont);
            ivCirculot = (ImageView)findViewById(R.id.ivCirculot);
            ivAndroidt = (ImageView)findViewById(R.id.ivAndroidt);
            ivCirculoAndt = (ImageView)findViewById(R.id.ivCirculoAndt);
        }

        String ruta = user.getRuta();
        if (ruta != null) {
            desactivarBotones();
            if(isTablet){
                new HiloCargaImagen(false, null, 1, ruta, ivPersont, densidad, isTablet, TAM_BASE_IMG).execute();
                ivAndroidt.setAdjustViewBounds(true);
                ivAndroidt.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivAndroidt.setImageResource(R.drawable.androgreent);
                ivCirculot.setAdjustViewBounds(true);
                ivCirculot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculot.setImageResource(R.drawable.circulot);
                ivCirculoAndt.setAdjustViewBounds(true);
                ivCirculoAndt.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculoAndt.setImageResource(R.drawable.circulot);
            }
            else{
                new HiloCargaImagen(false, null, 1, ruta, ivPerson, densidad, isTablet, TAM_BASE_IMG).execute();
                ivAndroid.setAdjustViewBounds(true);
                ivAndroid.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivAndroid.setImageResource(R.drawable.androgreen);
                ivCirculo.setAdjustViewBounds(true);
                ivCirculo.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculo.setImageResource(R.drawable.circulo);
                ivCirculoAnd.setAdjustViewBounds(true);
                ivCirculoAnd.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCirculoAnd.setImageResource(R.drawable.circulo);
            }
            activarBotones();
        }

        arrResultados = getResources().getStringArray(R.array.arrResultado);

        if(modo == MODO3)
        {
            arrOpciones = getResources().getStringArray(R.array.arr3opt);
            arrAcciones = getResources().getStringArray(R.array.arrAcciones3opt);
        }
        if(modo == MODO5)
        {
            arrOpciones = getResources().getStringArray(R.array.arr5opt);
            arrAcciones = getResources().getStringArray(R.array.arrAcciones5opt);
        }
        if(modo == MODO9)
        {
            arrOpciones = getResources().getStringArray(R.array.arr9opt);
            arrAcciones = getResources().getStringArray(R.array.arrAcciones9opt);
        }
        if(modo == MODO15)
        {
            arrOpciones = getResources().getStringArray(R.array.arr15opt);
            arrAcciones = getResources().getStringArray(R.array.arrAcciones15opt);
        }
        String elecAndroid = arrOpciones[calcularNumAleatorioEntero(arrOpciones.length)];

        ponerEleccion(eleccion,ivPersonEl);
        ponerEleccion(elecAndroid,ivAndroidEl);

        tvUserRes = (TextView)findViewById(R.id.tvUserRes);
        tvAndroidRes = (TextView)findViewById(R.id.tvAndroidRes);

        tvUserRes.setText(eleccion);
        tvAndroidRes.setText(elecAndroid);

        tvAccion = (TextView)findViewById(R.id.tvAccionResultado);
        tvResultado = (TextView)findViewById(R.id.tvResultado);

        tvAccion.setText(mensajeResultado(eleccion, elecAndroid));
        tvResultado.setText(mostrarResultado(eleccion, elecAndroid));

        int res = usuarioGanador(eleccion, elecAndroid);
        if(res == TABLAS) {
            user.setTablas(user.getTablas() + 1);
            tvResultado.setTextColor(Color.YELLOW);
        }
        if(res == GANAR) {
            user.setGanadas(user.getGanadas() + 1);
            tvResultado.setTextColor(Color.rgb(06,122,06));
        }
        if(res == PERDER) {
            user.setPerdidas(user.getPerdidas() + 1);
            tvResultado.setTextColor(Color.RED);
        }
    }

    private void activarBotones() {
        btnCambiarModo.setEnabled(true);
        btnEmpezar.setEnabled(true);
        btnEstadisticas.setEnabled(true);
        btnAjustesRes.setEnabled(true);
    }

    private void desactivarBotones() {
        btnCambiarModo.setEnabled(false);
        btnEmpezar.setEnabled(false);
        btnEstadisticas.setEnabled(false);
        btnAjustesRes.setEnabled(false);
    }

    public void pulsaAjustesR(View v)
    {
        mp = MediaPlayer.create(Resultado.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intAjuste = new Intent(Resultado.this, Ajustes.class);
        intAjuste.putExtra("USER", user);
        startActivity(intAjuste);
    }

    public void pulsaCambiarModo (View v){
        mp = MediaPlayer.create(Resultado.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intResul = new Intent(Resultado.this, Modalidad.class);
        intResul.putExtra("USER",user);
        startActivity(intResul);
    }

    public void pulsaEmpezar (View v){
        System.out.println("............. 11 .................... ");
        mp = MediaPlayer.create(Resultado.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Intent intResul = null;
        Bundle bundle = new Bundle();
        if(modo == MODO3) {
            intResul = new Intent(Resultado.this, SubMenuClasico.class);
            bundle.putInt("MODO", 3);
        }
        if(modo == MODO5) {
            intResul = new Intent(Resultado.this, SubMenuBigBang.class);
            bundle.putInt("MODO", 5);
        }
        if(modo == MODO9) {
            intResul = new Intent(Resultado.this, SubMenu9opt.class);
            bundle.putInt("MODO", 9);
        }
        if(modo == MODO15) {
            intResul = new Intent(Resultado.this, SubMenu15opt.class);
            bundle.putInt("MODO", 15);
        }
        intResul.putExtra("USER", user);
        startActivity(intResul);
    }

    public void pulsaEstadisticas (View v){
        mp = MediaPlayer.create(Resultado.this, R.raw.toc);
        new HiloSonido(false, mp).execute();
        Bundle bundle = new Bundle();
        Intent intResul = new Intent(Resultado.this, Estadistica.class);
        bundle.putInt("MODO", modo);
        intResul.putExtras(bundle);
        intResul.putExtra("USER",user);
        startActivity(intResul);
    }

    public String mostrarResultado(String user, String android){
        System.out.println("............. 16 .................... ");
        int res = usuarioGanador(user,android);
        if(res > 0)
            return arrResultados[1];
        else if(res < 0)
            return arrResultados[2];
        else
            return arrResultados[0];
    }

    public String mensajeResultado(String user, String android){
        for(int i=0; i<arrAcciones.length; i++)
        {
            String prim = primeraPalabra(arrAcciones[i]);
            String ult = ultimaPalabra(arrAcciones[i]);
            if((prim.compareToIgnoreCase(user) == 0 && ult.compareToIgnoreCase(android) == 0) || (prim.compareToIgnoreCase(android) == 0 && ult.compareToIgnoreCase(user) == 0))
                return arrAcciones[i];
        }
        return " ";
    }

    public String primeraPalabra(String cadena){
        int primerBlanco = cadena.indexOf(' ');
        return cadena.substring(0,primerBlanco);
    }

    public String ultimaPalabra(String cadena) {
        int ultimoBlanco = cadena.lastIndexOf(' ');
        return cadena.substring(ultimoBlanco+1);
    }

    public int usuarioGanador(String user, String android){
        int nElem = arrOpciones.length;
        int lim = nElem/2;
        int numUser = 0, numAndroid = 0;
        for(int i=0; i<nElem; i++)
        {
            if(arrOpciones[i].compareToIgnoreCase(user) == 0)
                numUser = i;
            if(arrOpciones[i].compareToIgnoreCase(android) == 0)
                numAndroid = i;
        }
        if(numUser == numAndroid)
            return 0;
        else{
            if(Math.max(numUser, numAndroid) == numUser)
            {
                if(numUser - numAndroid > lim)
                    return 1;
                else
                    return -1;
            }
            else
            {
                if(numAndroid - numUser > lim)
                    return -1;
                else
                    return 1;
            }
        }
    }

    public void ponerEleccion(String nombre, ImageView iv){
        System.out.println("............. 17 .................... ");
        if(modo == MODO3 && !isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedra);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijeras);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papel);
        }
        if(modo == MODO3 && isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedrat);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijerast);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papelt);
        }

        if(modo == MODO5 && !isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedra);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijeras);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.serpiente);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papel);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.spock);
        }
        if(modo == MODO5 && isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedrat);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijerast);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.serpientet);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papelt);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.spockt);
        }

        if(modo == MODO9 && !isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedra);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.fuego);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijeras);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.humano);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.esponja);
            if(arrOpciones[5].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papel);
            if(arrOpciones[6].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.aire);
            if(arrOpciones[7].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.agua);
            if(arrOpciones[8].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.pistola);
        }
        if(modo == MODO9 && isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedrat);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.fuegot);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijerast);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.humanot);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.esponjat);
            if(arrOpciones[5].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papelt);
            if(arrOpciones[6].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.airet);
            if(arrOpciones[7].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.aguat);
            if(arrOpciones[8].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.pistolat);
        }

        if(modo == MODO15 && !isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedra);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.fuego);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijeras);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.serpiente);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.humano);
            if(arrOpciones[5].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.arbol);
            if(arrOpciones[6].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.lobo);
            if(arrOpciones[7].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.esponja);
            if(arrOpciones[8].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papel);
            if(arrOpciones[9].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.aire);
            if(arrOpciones[10].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.agua);
            if(arrOpciones[11].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.dragon);
            if(arrOpciones[12].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.diablo);
            if(arrOpciones[13].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.relampago);
            if(arrOpciones[14].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.pistola);
        }
        if(modo == MODO15 && isTablet){
            if(arrOpciones[0].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.piedrat);
            if(arrOpciones[1].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.fuegot);
            if(arrOpciones[2].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.tijerast);
            if(arrOpciones[3].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.serpientet);
            if(arrOpciones[4].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.humanot);
            if(arrOpciones[5].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.arbolt);
            if(arrOpciones[6].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.lobot);
            if(arrOpciones[7].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.esponjat);
            if(arrOpciones[8].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.papelt);
            if(arrOpciones[9].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.airet);
            if(arrOpciones[10].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.aguat);
            if(arrOpciones[11].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.dragont);
            if(arrOpciones[12].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.diablot);
            if(arrOpciones[13].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.relampagot);
            if(arrOpciones[14].compareToIgnoreCase(nombre) == 0)
                iv.setImageResource(R.drawable.pistolat);
        }
    }

    public int calcularNumAleatorioEntero(int tope){

        int num =  (int)Math.floor(Math.random()*tope);
        return num;
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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

