package com.ggm.ad.ut2;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class LogAplication {

   private List<Log> listaLog;


    public LogAplication() {
    }
    public LogAplication(List<Log> listaLogs) {
        this.listaLog = listaLogs;
    }
    @XmlElement
    public List<Log> getListaLog() {
        return listaLog;
    }

    public void setListaLog(List<Log> listaLog) {
        this.listaLog = listaLog;
    }
}
