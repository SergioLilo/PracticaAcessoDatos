package com.ggm.ad.ut2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExportacionJSON {

    public  static  void exportJSON( List<Log> listaLogs ){

        Gson transfJson = new GsonBuilder().setPrettyPrinting().create();
        Scanner teclado=new Scanner(System.in);
        System.out.println("Escribe el como quieres que se llame el archivo");
        String nombreFile=teclado.next();
        try(FileWriter escritor = new FileWriter(nombreFile+".json")){

            transfJson.toJson(listaLogs, escritor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
