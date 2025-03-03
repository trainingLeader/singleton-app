package com.singleton.utilidad;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum Singletonenum {
    INSTANCIA; // Singleton
    private final Map<String, String> configuraciones = new HashMap<>();

    public void getInstance() {
        cargarConfiguraciones("config.properties");
    }
        // Método para cargar configuraciones desde un archivo
    private void cargarConfiguraciones(String rutaArchivo) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (FileInputStream archivo = new FileInputStream(classLoader.getResource(rutaArchivo).getFile())) {
            Properties propiedades = new Properties();
            propiedades.load(archivo);
            for (String clave : propiedades.stringPropertyNames()) {
                configuraciones.put(clave, propiedades.getProperty(clave));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar configuraciones: " + e.getMessage());
        }
    }

    // Método para obtener una configuración
    public String get(String clave) {
        return configuraciones.getOrDefault(clave, "Valor no encontrado");
    }

    // Método para establecer una nueva configuración en el HashMap
    public void set(String clave, String valor) {
        configuraciones.put(clave, valor);
    }

    // Método para mostrar todas las configuraciones almacenadas
    public void mostrarConfiguraciones() {
        System.out.println("Configuraciones actuales:");
        configuraciones.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }
}
