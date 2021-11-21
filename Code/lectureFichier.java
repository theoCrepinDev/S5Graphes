import java.io.*;
import java.util.Scanner;

public class LectureFichiers{
    static int inf = Integer.MAX_VALUE; //permet de représenter l'infini

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
        
        resultat[val_actuelle] = stri.substring(debut_temporaire, len );
        return resultat;
    }

    //fonction qui prend en argument l'adresse d'un fichier texte représentant un graphe et renvoit sa 
    //matrice d'adjacence
    public static double[][] matriceAdjacence(String fichier) throws FileNotFoundException{
        FileInputStream file = new FileInputStream(fichier);
        Scanner scanner = new Scanner(file);

        //lecture du nombre de sommets
        String nbrSommetsString = scanner.nextLine();
        int nbrSommets = Integer.parseInt(nbrSommetsString);

        //initialisation du tableau de la matrice d'adjacence
        //de taille nbrSommets,nbrSommets
        double[][] matriceAdjacence = new double[nbrSommets][nbrSommets];

        String line2 = scanner.nextLine();

        //initialisation de toutes les valeurs du tableau a inf
        for(int i = 0; i < nbrSommets; i++){
            for(int j = 0; j < nbrSommets; j++){
                matriceAdjacence[i][j] = inf;
            }
        }

        while (scanner.hasNextLine()){
            String lineString = scanner.nextLine();
            //On récupère le tableau des Trois valeures séparés en String
            String[] lineSepString = separation(lineString);
            //on met les valeures en int dans des variables
            int i = Integer.parseInt(lineSepString[0]);
            int j = Integer.parseInt(lineSepString[1]);
            double cout = Double.parseDouble(lineSepString[2]);
            matriceAdjacence[i][j] = cout;
        }

        scanner.close();
        return matriceAdjacence;
    }


    public static void main(String[] args) throws FileNotFoundException{
        String fichier = "graphe.txt";

        double[][] mat = matriceAdjacence(fichier);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }

    }
    
}
