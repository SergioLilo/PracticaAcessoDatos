package com.ggm.ad.ut2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiltradorLog {
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);
        String decision;
        List<String> fichero=new ArrayList<>();
        List<Log> listaLogs=new ArrayList<>();
        List<Log> listaLogsFiltrada=new ArrayList<>();
        int lineasNoValidas=0;

        boolean terminarPrograma=false;

        try {
            String rutaFichero = "src/main/log_ejemplo.log";
            Path ruta=comprobadorRuta();

            fichero=Files.readAllLines(ruta);
            lineasNoValidas=exportacionArchivo(fichero, listaLogs,lineasNoValidas);


            while (!terminarPrograma){
                listaLogsFiltrada=seleccionNivel(listaLogs);
                System.out.println("Logs Filtrados: ");
                System.out.println(listaLogsFiltrada);
                seleccionExportacion(listaLogsFiltrada);
                System.out.println("Logs Sin Filtrado: ");
                System.out.println(listaLogs);

                System.out.println("Quiere Terminar el programa? si/no");
                decision=teclado.next();
                if (decision.equals("si")){
                    terminarPrograma=true;
                }
            }


            System.out.println("Numero de lineas no validas: "+lineasNoValidas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InputMismatchException e){
            System.out.println("TIENES QUE INTRODUCIR UN NUMERO");
        }

    }

    private static Path comprobadorRuta(){

        String rutaFichero;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la ruta de tu archivo:");
        rutaFichero=teclado.next();
        while (!Files.exists(Path.of(rutaFichero))){
            System.out.println("no existe el fichero, introduce su ruta de nuevo: ");
            rutaFichero=teclado.next();
        }

        Path ruta=Paths.get(rutaFichero);
        return ruta;
    }
    private static int exportacionArchivo(List<String> fichero, List<Log> listaLogs, int lineasNoValidas) {
        String partes[];
        String patron = "^\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\] \\[(ERROR|INFO|WARNING)\\] .+$";
        Pattern pattern = Pattern.compile(patron);
        for (String linea: fichero){


            Matcher matcher = pattern.matcher(linea);

            if (matcher.matches()) {

                partes = linea.split("]");

                partes[0] = partes[0].substring(1);
                partes[1] = partes[1].substring(2);
                partes[2] = partes[2].substring(1);

                listaLogs.add(new Log(partes[0], partes[1], partes[2]));
            }else{
                lineasNoValidas++;

            }
        }

        System.out.println(lineasNoValidas);
        return lineasNoValidas;
    }
    private static void seleccionExportacion(List<Log> listaLogs) throws IOException {
        Scanner teclado=new Scanner(System.in);
        int opc;
        boolean salir=false;

        System.out.println("Que quiere hacer?\n" +
                "1.Exportar a XML\n" +
                "2.Exportar a JSON\n" +
                "Escriba el numero de la opcion:");
        opc=teclado.nextInt();
        while(!salir) {

        if(opc==1){
            ExportacionXML.exportXML(listaLogs);
            salir=true;
        }
        else if(opc==2){
            ExportacionJSON.exportJSON(listaLogs);
            salir=true;
        }else{
            System.out.println("Opcion incorrecta");
            System.out.println("Que quiere hacer?\n" +
                    "1.Exportar a XML\n" +
                    "2.Exportar a JSON\n" +
                    "Escriba el numero de la opcion:");
            opc=teclado.nextInt();
        }

        }
    }
    private static List<Log> seleccionNivel(List<Log> listaLogs) {
        Scanner teclado = new Scanner(System.in);
        String[] opciones = {"NINGUNO", "INFO", "WARNING", "ERROR"};
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
            if (!opcionValida) {
                System.out.println("OPCION INCORRECTA, ESCRIBELA DE NUEVO");
            }
        } while (!opcionValida);

        List<Log> listaLogFiltrada;

        if (!opc.equals("NINGUNO")) {
            listaLogFiltrada = new ArrayList<>();
            for (Log logs : listaLogs) {
                if (logs.getNivel().equals(opc)) {
                    listaLogFiltrada.add(logs);
                }

            }
        } else {
            return listaLogs;
        }
        return listaLogFiltrada;
    }

}
