package co.com.pruebatecnica.helpers;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Properties {
    String RUTA_ARCHIVO_PROPERTIES = "src/main/resources/properties/utilities.properties";

    public Properties() {
    }

    private java.util.Properties iniciarProperties() {
        java.util.Properties prop = new java.util.Properties();
        FileInputStream is = null;

        try {
            is = new FileInputStream(this.RUTA_ARCHIVO_PROPERTIES);
            prop.load(is);
        } catch (IOException var4) {
            System.out.println(var4.toString());
        }

        return prop;
    }

    public String getFieldProperties(String clave) {
        java.util.Properties prop = this.iniciarProperties();
        return prop.getProperty(clave);
    }

    public void setFieldProperties(String clave, String newProperty) throws IOException {
        java.util.Properties prop = this.iniciarProperties();
        prop.setProperty(clave, newProperty);
        prop.store(new FileWriter(RUTA_ARCHIVO_PROPERTIES), "Actualización de la propiedad: " + clave);
    }

    public void guardarNumeroSolicitud(String numeroSolicitud) throws IOException {
        setFieldProperties("numeroSolicitud", numeroSolicitud);
    }
}
