import java.io.*;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class LectureFichiers{

    //fonction qui prend en argument une ligne du fichier composée de arrete_depart arrete_arrivée cout et
    //renvoit les trois valeurs séparés dans un tableau de string
    public static String[] separation(String stri){
        String[] resultat = new String[3];
        int len = stri.length();
        int val_actuelle = 0;
        int debut_temporaire = 0;
        int caractere_en_cour = 0;
        while(caractere_en_cour != len ){
            if(Character.isWhitespace(stri.charAt(caractere_en_cour))){
                resultat[val_actuelle] = stri.substring(debut_temporaire, caractere_en_cour);
                debut_temporaire = caractere_en_cour + 1;
                val_actuelle++;
            }
            caractere_en_cour++;
        }

        resultat[val_actuelle] = stri.substring(debut_temporaire, len - 1);
        return resultat;
    }




    public static void main(String[] args) throws FileNotFoundException{
        FileInputStream file = new FileInputStream("test.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();

        String a = "12";
        int b = Integer.parseInt(a); //convertit un string en sa valeur en int

        System.out.println(b);
    }
}