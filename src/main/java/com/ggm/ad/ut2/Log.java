package com.ggm.ad.ut2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder={"fechaHora","nivel","mensaje"})
@XmlRootElement
public class Log {
    String fechaHora;
    String nivel;
    String mensaje;


    public Log(String fecha, String nivel, String mensaje) {
        this.fechaHora = fecha;
        this.nivel = nivel;
        this.mensaje = mensaje;
    }

    public Log() {

    }

    @XmlElement
    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
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
                "fecha='" + fechaHora + '\'' +
                ", nivel='" + nivel + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
