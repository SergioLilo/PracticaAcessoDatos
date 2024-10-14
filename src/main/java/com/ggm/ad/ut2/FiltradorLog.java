package com.ggm.ad.ut2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            seleccionNivel(listaLogs);

            ExportacionJSON.exportJSON(listaLogs);
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
    private static void seleccionNivel(List<Log> listaLogs){
        Scanner teclado=new Scanner(System.in);
        String[] opciones= {"NINGUNO", "INFO", "WARNING", "ERROR"};
        String opc;
        boolean opcionValida = false;

        do {
            System.out.println("Escriba el nivel para filtrar");
            System.out.println("1.NINGUNO: no habrá filtro\n" +
                    "2.INFO\n" +
                    "3.WARNING\n" +
                    "4.ERROR\n" +
                    "Escriba el nombre del nivel:");
            opc = teclado.next().toUpperCase();


            for (String level : opciones) {
                if (opc.equals(level)) {
                    opcionValida = true;
                }
            }
            if (!opcionValida){
                System.out.println("OPCION INCORRECTA, ESCRIBELA DE NUEVO");
            }
        }while (!opcionValida);


        for (Log logs: listaLogs){
            if (!logs.getNivel().equals(opc)){

            }

        }


    }

}
