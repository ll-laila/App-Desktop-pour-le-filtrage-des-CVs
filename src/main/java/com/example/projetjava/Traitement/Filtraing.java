package com.example.projetjava.Traitement;

import com.example.projetjava.dao.impl.OffreDaoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.projetjava.controller.AccueilController.id_offre;
import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;


public class Filtraing {

    public static List<String>  CvFiltring(){

        // Créer une liste pour stocker les chaînes de caractères

        List<String> stringsList = new ArrayList<>();

        File file = new File("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu+".txt");

        Scanner scanner = null;

        try {

            scanner = new Scanner(file);

        // Skip the first line
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNext()) {

            String word = scanner.next();
            // Faites quelque chose avec le mot
            stringsList.add(word);

        }

        String[] text = stringsList.toArray(new String[0]);

        List<String> wordsToSearch1 = new ArrayList<>();

            List<String> wordsToSearch = new ArrayList<>();

            OffreDaoImpl offre = new OffreDaoImpl();

            wordsToSearch = offre.getOffreById(id_offre);

            String[] words = wordsToSearch.get(0).split("\\s+");

            for (String word : words) {
                wordsToSearch1.add(word);
            }

            System.out.println("Mots trouvés : " + searchWords(text, wordsToSearch1));
        return searchWords(text, wordsToSearch1);


        } catch (FileNotFoundException e) {
            System.out.println("er");

        } finally {
            if (scanner != null) {
                scanner.close();
            }

        }

        return null;
    }


    public static float score(){
        List<String> wordsToSearch = new ArrayList<>();

        OffreDaoImpl offre = new OffreDaoImpl();

        wordsToSearch = offre.getOffreById(id_offre);

        String[] words = wordsToSearch.get(0).split("\\s+");
        float scor = 0;

        if(CvFiltring() != null){
            scor = (float) CvFiltring().size()/words.length;
        }
        return scor;
    }
    public static void main(String[] args) {

        CvFiltring();
    }


    public static List<String> searchWords(String[] text, List<String> wordsToSearch) {
        Set<String> foundWords = new LinkedHashSet<>();

        for (String sentence : text) {
            for (String wordToSearch : wordsToSearch) {
                String pattern = "\\b" + wordToSearch.toLowerCase() + "\\b";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(sentence.toLowerCase());

                if (matcher.find()) {
                    foundWords.add(wordToSearch);
                }
            }
        }

        return new ArrayList<>(foundWords);
    }
}
