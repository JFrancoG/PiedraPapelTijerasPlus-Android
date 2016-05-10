package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.media.MediaPlayer;
import android.os.AsyncTask;

/**
 * Created by drpuerk on 4/04/16.
 */


public class HiloSonido extends AsyncTask <String, Float, Void> {
    private boolean sonidoReproducido;
    private MediaPlayer mp;

    public HiloSonido(boolean sonidoReproducido, MediaPlayer mp) {
        this.sonidoReproducido = sonidoReproducido;
        this.mp = mp;
    }

    @Override
    protected Void doInBackground(String... s) {

        while (!isCancelled() && !sonidoReproducido) {
            mp.start();
            sonidoReproducido = true;
        }
        return null;
    }



}