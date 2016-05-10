package com.games.apps.drpuerk.piedrapapeltijerasplus;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * Created by drpuerk on 29/03/16.
 */
public class Imagen extends Activity{

    private static final int LDPI = 120;
    private static final int MDPI = 160;
    private static final int HDPI = 240;
    private static final int XHDPI = 320;
    private static final int XXHDPI = 480;
    private static final int XXXHDPI = 640;
    private static final float FACTOR_LDPI = (float)0.75;
    private static final int FACTOR_MDPI = 1;
    private static final float FACTOR_HDPI = (float)1.5;
    private static final int FACTOR_XHDPI = 2;
    private static final int FACTOR_XXHDPI = 3;
    private static final int FACTOR_XXXHDPI = 4;


    public static Bitmap cropBitmap(Bitmap original) {
        int altura = original.getHeight();
        int anchura = original.getWidth();
        int lado = 0;
        if(anchura <= altura)
            lado = anchura;
        else
            lado = altura;
        Bitmap croppedImage = Bitmap.createBitmap(lado, lado, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(croppedImage);

        Rect srcRect = new Rect(0, 0, original.getWidth(), original.getHeight());
        Rect dstRect = new Rect(0, 0, lado, lado);

        int dx = (srcRect.width() - dstRect.width()) / 2;
        int dy = (srcRect.height() - dstRect.height()) / 2;

// If the srcRect is too big, use the center part of it.
        srcRect.inset(Math.max(0, dx), Math.max(0, dy));

// If the dstRect is too big, use the center part of it.
        dstRect.inset(Math.max(0, -dx), Math.max(0, -dy));

// Draw the cropped bitmap in the center
        canvas.drawBitmap(original, srcRect, dstRect, null);

        original.recycle();

        return croppedImage;
    }

    public static Bitmap roundedBipmap(Bitmap bitmap, int factorRed){
        int altura = bitmap.getHeight();
        int anchura = bitmap.getWidth();
        int lado = 0;
        if(anchura <= altura)
            lado = anchura;
        else
            lado = altura;

        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);

        final int color = Color.BLACK;//0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final int roundPx = lado/factorRed;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return result;
    }

    public static double calcularPulgadas(int ancho, int alto, int densidad){
        double pulgadas = 0;
        pulgadas = Math.sqrt(Math.pow(ancho,2)+Math.pow(alto,2))/densidad;
        return pulgadas;
    }


    public static int calcularAltura(int densidad, boolean tablet, int tambase) {
        int tam = 0;
        if(tablet)
            tambase = 2 * tambase;

        switch (densidad){
            case LDPI: tam = (int)(tambase * FACTOR_LDPI);
                break;
            case MDPI: tam =  tambase * FACTOR_MDPI;
                break;
            case HDPI: tam =  (int)(tambase * FACTOR_HDPI);
                break;
            case XHDPI: tam =  tambase * FACTOR_XHDPI;
                break;
            case XXHDPI: tam =  tambase * FACTOR_XXHDPI;
                break;
            case XXXHDPI: tam =  tambase * FACTOR_XXXHDPI;
                break;
            default:    tam =  tambase;
        }

        return tam;
    }

    public static Bitmap cargarImagen(String ruta){
        Bitmap bitmap = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(ruta);
            //new FileInputStream(getApplicationContext().getFilesDir().getPath()+ "/imagen.gif");
            bitmap = BitmapFactory.decodeStream(fileInputStream);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return bitmap;
    }
}
