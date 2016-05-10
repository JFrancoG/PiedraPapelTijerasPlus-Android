package com.games.apps.drpuerk.piedrapapeltijerasplus;

import java.io.Serializable;

/**
 * Created by root on 7/12/15.
 */
public class Usuario implements Serializable
{
    private int densidad;
    private boolean tablet;

    private String nick;
    private String email;
    private String ruta;
    private int ganadas;
    private int perdidas;
    private int tablas;

    public Usuario(){ }

    public Usuario(String nick, String email){
        this.nick = nick;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRuta() {
        return ruta;
    }
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public int getGanadas() {
        return ganadas;
    }
    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }
    public int getPerdidas() {
        return perdidas;
    }
    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }
    public int getTablas() {
        return tablas;
    }
    public void setTablas(int tablas) {
        this.tablas = tablas;
    }
    public int getDensidad(){
        return densidad;
    }
    public void setDensidad(int densidad){
        this.densidad = densidad;
    }
    public boolean getTablet(){
        return tablet;
    }
    public void setTablet(boolean tablet){
        this.tablet = tablet;
    }

}
