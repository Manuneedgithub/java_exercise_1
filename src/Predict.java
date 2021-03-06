import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Predict implements Command{

    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner sc) {
        System.out.println("Enter file path :");
        String path = sc.nextLine();
        Path filePath = Paths.get(path);
        try {
            String content = Files.readString(filePath);
            String[] word_list = content.split(" ");
            System.out.println("Enter a word :");
            String mot = sc.nextLine();
            String phrase = mot;
            for (int i = 0; i < 19; i++) {
                ArrayList<String> mot_apres = new ArrayList<String>();
                //on met tout les mots 'apres' le mot acutel dans une liste
                for (int j = 0; j < word_list.length; j++) {
                    if (word_list[j].equals(mot)) {
                        //System.out.println("j'ajoute : " + word_list[j + 1]);
                        mot_apres.add(word_list[j + 1]);
                    }
                }
                Collections.sort(mot_apres);
                //System.out.println("liste des mots apres " + mot_apres);


                int maxi = 1;
                String mot_max = mot_apres.get(mot_apres.size() - 1) ;
                int counte = 1;
                for (int w = 1; w < mot_apres.size(); w++){
                    if (mot_apres.get(w).equals(mot_apres.get(w - 1))){
                        counte += 1;
                    }
                    else{
                        if (counte > maxi) {
                            mot_max = mot_apres.get(w - 1);
                            maxi = counte;
                        }
                        counte = 1;
                    }
                }
                if (counte > maxi) {
                    mot_max = mot_apres.get(mot_apres.size() - 1);
                    maxi = counte;
                }
                //System.out.println("j'ai hoisis le mot : " + mot_max);
                phrase += " " + mot_max;
                mot= mot_max;
/*
                String curr = mot_apres.get(0);
                int max = 0;
                int count = 1;
                for (int m = 1; m < mot_apres.size(); m++) {
                    if (mot_apres.get(m) != curr){
                        if (count > max){
                            curr = mot_apres.get(m - 1);
                            max = count;
                        }
                        count = 0;
                    }
                    else{
                        count += 1;
                    }
                }*/

                //System.out.println("current : " + curr);
                //phrase += " " + mot_max;
                //mot = curr;

            }
            System.out.println(phrase);
        }
        catch(IOException e) {
            System.out.println("Unreadable file: " + e);
            return false;
        }
        return true;
    }

}