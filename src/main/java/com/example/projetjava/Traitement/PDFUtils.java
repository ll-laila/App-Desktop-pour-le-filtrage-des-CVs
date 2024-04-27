package com.example.projetjava.Traitement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PDFUtils {

    public static byte[] convertPDFToByteArray(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        }
    }
}