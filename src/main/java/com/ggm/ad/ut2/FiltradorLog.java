package com.ggm.ad.ut2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FiltradorLog {
    public static void main(String[] args) {

        List<String> fichero=new ArrayList<>();
        List<Log> listaLogs=new ArrayList<>();


        try {
            String rutaFichero = "src/main/log_ejemplo.log";
            Path ruta=Paths.get(rutaFichero);
            Files.exists(ruta);
            fichero=Files.readAllLines(ruta);

            exportacionArchivo(fichero, listaLogs);
            ExportacionXML.exportXML(listaLogs);

            System.out.println(listaLogs);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exportacionArchivo(List<String> fichero, List<Log> listaLogs) {
        String partes[];
        for (String linea: fichero){
            partes=linea.split("]");

            partes[0] = partes[0].substring(1);
            partes[1] = partes[1].substring(2);
            partes[2]= partes[2].substring(1);

            listaLogs.add(new Log(partes[0],partes[1],partes[2] ));
            //listaLogs.add(new Log());
        }
    }

}
