package com.example.projetjava.Traitement;
import com.spire.pdf.*;
import java.io.*;

import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;

public class ExtractTextCv {


    public static void ExtractText(){
        PdfDocument pdf = new PdfDocument();

        //Load the file from disk
        pdf.loadFromFile("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu);

        //Create a StringBuilder instance
        StringBuilder sb = new StringBuilder();

        PdfPageBase page;
        //Traverse all the pages in the document.
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            page = pdf.getPages().get(i);
            //Extract the text from the pdf pages
            sb.append(page.extractText(true));
        }
        FileWriter writer;

        try {
            //Create a new txt file to save the extracted text
            writer = new FileWriter("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu+".txt");
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdf.close();
    }


}


