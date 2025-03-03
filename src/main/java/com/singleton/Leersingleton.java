package com.singleton;

import com.singleton.utilidad.Singletonenum;

public class Leersingleton {
    public static void main(String[] args) {
        Singletonenum config = Singletonenum.INSTANCIA;
        config.getInstance();
        config.mostrarConfiguraciones();
    }
}
