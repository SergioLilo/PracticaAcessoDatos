package com.ggm.ad.ut2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.List;

public class ExportacionXML {

    public  static  void exportXML( List<Log> listaLogs){

        try {


            JAXBContext context = JAXBContext.newInstance(LogAplication.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File logXML=new File("logs.xml");

            LogAplication logAplication=new LogAplication(listaLogs);

            marshaller.marshal(logAplication,logXML);




        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
