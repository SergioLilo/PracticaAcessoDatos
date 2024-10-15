package com.ggm.ad.ut2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ExportacionXML {

    public  static  void exportXML( List<Log> listaLogs) throws IOException {

        try {
            Scanner teclado=new Scanner(System.in);
            System.out.println("Escribe el como quieres que se llame el archivo");
            String nombreFile=teclado.next();
            JAXBContext context = JAXBContext.newInstance(LogAplication.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File logXML=new File(nombreFile+".xml");

            LogAplication logAplication=new LogAplication(listaLogs);

            marshaller.marshal(logAplication,logXML);





        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
