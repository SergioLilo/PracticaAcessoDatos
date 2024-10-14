package com.ggm.ad.ut2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Log {
    String fecha;
    String nivel;
    String mensaje;


    public Log(String fecha, String nivel, String mensaje) {
        this.fecha = fecha;
        this.nivel = nivel;
        this.mensaje = mensaje;
    }

    public Log() {

    }

    @XmlElement
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @XmlElement
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    @XmlElement
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Log{" +
                "fecha='" + fecha + '\'' +
                ", nivel='" + nivel + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
