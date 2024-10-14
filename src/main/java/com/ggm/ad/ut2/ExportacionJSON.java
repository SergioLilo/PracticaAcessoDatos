package com.ggm.ad.ut2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportacionJSON {

    public  static  void exportJSON( List<Log> listaLogs ){

        Gson transfJson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter escritor = new FileWriter("logs.json")){

            transfJson.toJson(listaLogs, escritor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
