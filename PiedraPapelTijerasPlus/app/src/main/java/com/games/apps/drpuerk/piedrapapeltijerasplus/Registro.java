package com.games.apps.drpuerk.piedrapapeltijerasplus;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends Activity {

    private final int COD_FOTO = 100;
    private final int FOTO_SELEC = 200;
    private final int MAXNICK = 10;

    private final int TAM_BASE_IMG = 64;
    private final int TAM_BASE_CIRC = 64;

    private String APP_DIR = "Android/Anteriores/PiedraPapelTijerasGeneralizacion/";
    private String FOTOS_DIR = APP_DIR + "Fotos";
    private String ARCHIVO_TEMP = "temporal.jpg";

    private Usuario user;
    private MediaPlayer mp;
    private String msjErrorNick,msjErrorNick2,msjErrorEmail,strTitCuadroDialogo,strTitCargaImagen;

    private EditText etNick, etEmail;
    private ImageView ivFoto, ivFotot, ivCuadrado, ivCuadradot;
    private Button btnGuardarCambios;
    private String[] arrOpcFoto;

    private int densidad;
    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        user = (Usuario)getIntent().getExtras().getSerializable("USER");

        densidad = user.getDensidad();
        isTablet = user.getTablet();

        btnGuardarCambios = (Button) findViewById(R.id.btnGuardarCambios);
        etNick = (EditText)findViewById(R.id.etNick);
        etEmail = (EditText)findViewById(R.id.etEmail);
        ivFoto = (ImageView)findViewById(R.id.ivfotoperfil);
        ivFotot = (ImageView)findViewById(R.id.ivfotoperfilt);
        ivCuadrado = (ImageView)findViewById(R.id.ivCuadrado);
        ivCuadradot = (ImageView)findViewById(R.id.ivCuadradot);

        if(user.getNick() != null)
            etNick.setText(user.getNick());
        if(user.getEmail() != null)
            etEmail.setText(user.getEmail());

        String ruta = user.getRuta();

        if (ruta != null){
            desactivarBotones();
            if(!isTablet){
                new HiloCargaImagen(false, null, 4, ruta, ivFoto, densidad, isTablet, TAM_BASE_IMG).execute();
                ivCuadrado.setAdjustViewBounds(true);
                ivCuadrado.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCuadrado.setImageResource(R.drawable.cuadrado);
            }
            else{
                new HiloCargaImagen(false, null, 4, ruta, ivFotot, densidad, isTablet, TAM_BASE_IMG).execute();
                ivCuadradot.setAdjustViewBounds(true);
                ivCuadradot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                ivCuadradot.setImageResource(R.drawable.cuadradot);
            }
            activarBotones();
        }

        msjErrorNick = getResources().getString(R.string.MensajeErrorNick);
        msjErrorNick2 = getResources().getString(R.string.MensajeErrorNick2);
        msjErrorEmail = getResources().getString(R.string.MensajeErrorEmail);

        arrOpcFoto = getResources().getStringArray(R.array.arrAccionesFoto);
        strTitCuadroDialogo = getResources().getString(R.string.strTitCuadroDialogo);
        strTitCargaImagen = getResources().getString(R.string.strTitCargaImagen);
    }

    private void activarBotones() {
        btnGuardarCambios.setEnabled(true);
    }

    private void desactivarBotones() {
        btnGuardarCambios.setEnabled(false);
    }

    public boolean emailCorrecto(String email) {

        boolean valido = false;

        Pattern patronEmail = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");

        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.matches()) {
            valido = true;
        }
        return valido;
    }

    public void pulsaRegistrar(View v)
    {
        mp = MediaPlayer.create(Registro.this, R.raw.toc);
        new HiloSonido(false, mp).execute();

        if(etNick.getText().toString().length() == 0)
            etNick.setError(msjErrorNick);
        if(etNick.getText().toString().length() > MAXNICK)
            etNick.setError(msjErrorNick2);

        if(!emailCorrecto(etEmail.getText().toString()))
            etEmail.setError(msjErrorEmail);

        if(etNick.getText().toString().length() > 0 && etNick.getText().toString().length() <= MAXNICK && emailCorrecto(etEmail.getText().toString())) {
            user.setNick(etNick.getText().toString());
            user.setEmail(etEmail.getText().toString());

            Intent intMod = new Intent(Registro.this, Modalidad.class);
            intMod.putExtra("USER",user);
            startActivity(intMod);
        }
    }

    public void pulsaCargarFoto(View v){
        System.out.println("-------- 1 --------");
        final AlertDialog.Builder cuadroDialogo = new AlertDialog.Builder(Registro.this);
        cuadroDialogo.setTitle(strTitCuadroDialogo);
        System.out.println("-------- 2 --------");
        cuadroDialogo.setItems(arrOpcFoto, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int opt) {
                if (arrOpcFoto[opt] == arrOpcFoto[0])
                    openCamara();
                else if (arrOpcFoto[opt] == arrOpcFoto[1]) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, strTitCargaImagen), FOTO_SELEC);
                } else
                    dialog.dismiss();
            }
        });
        cuadroDialogo.show();
    }

    private void openCamara() {
        System.out.println("-------- oc 1 --------");
        File arch = new File(Environment.getExternalStorageDirectory(),FOTOS_DIR);
        arch.mkdirs();

        String path = Environment.getExternalStorageDirectory() + File.separator + FOTOS_DIR + File.separator + ARCHIVO_TEMP;
        File newArch = new File(path);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newArch));
        startActivityForResult(intent, COD_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case COD_FOTO:
                if(resultCode == RESULT_OK){
                    String dir = Environment.getExternalStorageDirectory() + File.separator + FOTOS_DIR + File.separator + ARCHIVO_TEMP;
                    decodificarBitmap(dir);
                }
                break;
            case FOTO_SELEC:
                if(resultCode == RESULT_OK){
                    Uri path = data.getData();
                    System.out.println("-------- galeria --------");
                    if(!isTablet){
                        ivFoto.setImageURI(path);
                        Bitmap imagen = ((BitmapDrawable)ivFoto.getDrawable()).getBitmap();
                        String ruta = guardarImagen(getApplicationContext(), "imagen", imagen);
                        user.setRuta(ruta);
                        new HiloCargaImagen(false, null, 4, ruta, ivFoto, densidad, isTablet, TAM_BASE_IMG).execute();
                        ivCuadrado.setAdjustViewBounds(true);
                        ivCuadrado.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                        ivCuadrado.setImageResource(R.drawable.cuadrado);
                    }
                    else{
                        ivFotot.setImageURI(path);
                        Bitmap imagen = ((BitmapDrawable)ivFotot.getDrawable()).getBitmap();
                        String ruta = guardarImagen(getApplicationContext(), "imagen", imagen);
                        user.setRuta(ruta);
                        new HiloCargaImagen(false, null, 4, ruta, ivFotot, densidad, isTablet, TAM_BASE_IMG).execute();
                        ivCuadradot.setAdjustViewBounds(true);
                        ivCuadradot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
                        ivCuadradot.setImageResource(R.drawable.cuadradot);
                    }
                }
                break;
        }
    }

    private void decodificarBitmap(String dir) {
        System.out.println("-------- foto --------");

        if(!isTablet){
            Bitmap bitmap = BitmapFactory.decodeFile(dir);
            bitmap = Imagen.cropBitmap(bitmap);
            bitmap = Imagen.roundedBipmap(bitmap,4);
            ivFoto.setAdjustViewBounds(true);
            ivFoto.setImageBitmap(bitmap);
            ivFoto.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_IMG));

            Bitmap imagen = ((BitmapDrawable)ivFoto.getDrawable()).getBitmap();
            String ruta = guardarImagen(getApplicationContext(), "imagen", imagen);
            user.setRuta(ruta);

            ivCuadrado.setAdjustViewBounds(true);
            ivCuadrado.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
            ivCuadrado.setImageResource(R.drawable.cuadrado);
        }
        else{
            System.out.println("-------- foto 0 --------");
            Bitmap bitmap = BitmapFactory.decodeFile(dir);
            System.out.println("-------- foto 1 --------");
            bitmap = Imagen.cropBitmap(bitmap);
            System.out.println("-------- foto 2 --------");
            bitmap = Imagen.roundedBipmap(bitmap,4);
            System.out.println("-------- foto 3 --------");
            ivFotot.setAdjustViewBounds(true);
            ivFotot.setImageBitmap(bitmap);
            System.out.println("-------- foto 4 --------");
            ivFotot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_IMG));
            System.out.println("-------- foto 5 --------");
            Bitmap imagen = ((BitmapDrawable)ivFotot.getDrawable()).getBitmap();
            System.out.println("-------- foto 6 --------");
            String ruta = guardarImagen(getApplicationContext(), "imagen", imagen);
            System.out.println("-------- foto 7 --------");
            user.setRuta(ruta);

            ivCuadradot.setAdjustViewBounds(true);
            ivCuadradot.setMaxHeight(Imagen.calcularAltura(densidad, isTablet, TAM_BASE_CIRC));
            ivCuadradot.setImageResource(R.drawable.cuadradot);
        }
    }

    private String guardarImagen (Context context, String nombre, Bitmap imagen){
        ContextWrapper cw = new ContextWrapper(context);
        File dirImages = cw.getDir("Imagenes", Context.MODE_PRIVATE);
        File myPath = new File(dirImages, nombre + ".png");

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(myPath);
            imagen.compress(Bitmap.CompressFormat.JPEG, 10, fos);
            fos.flush();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return myPath.getAbsolutePath();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
