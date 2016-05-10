package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

/**
 * Created by drpuerk on 5/04/16.
 */
public class HiloCargaImagen extends AsyncTask<String, Float, Bitmap> {

    private boolean imagenCargada;
    private Bitmap bitmap;
    private int factorRedImagen;
    private String ruta;
    private ImageView iv;
    private int densidad;
    private boolean isTablet;
    private int tambase;

    public HiloCargaImagen(boolean imagenCargada, Bitmap bitmap, int factorRedImagen, String ruta, ImageView iv, int densidad, boolean isTablet, int tamBase){

        this.imagenCargada = imagenCargada;
        this.bitmap = bitmap;
        this.factorRedImagen = factorRedImagen;
        this.ruta = ruta;
        this.iv = iv;
        this.densidad = densidad;
        this.isTablet = isTablet;
        this.tambase = tamBase;
    }


    @Override
    protected Bitmap doInBackground(String... s) {

        while (!isCancelled() && !imagenCargada) {

            bitmap = Imagen.cargarImagen(ruta);
            bitmap = Imagen.cropBitmap(bitmap);
            bitmap = Imagen.roundedBipmap(bitmap, factorRedImagen);

            imagenCargada = true;
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {

        if (iv != null){
            iv.setAdjustViewBounds(true);
            iv.setImageBitmap(bitmap);
            iv.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, tambase));
        }
    }

}
