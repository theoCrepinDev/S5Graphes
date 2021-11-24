import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException{
        //while true pour que le programme tourne en boucle
        while(true){
            //y a t-il plusieurs graphes par fichier texte ou chaques graphe a son propre fichier ?
            //a coder interface de gestion de la demande degraphe et on dit que le graphe à retourner se situe dans le dossier
            //test.txt soit dans la variable grapheTraiter

            String grapheTraiter = "test.txt";
        
            //Etape 1 récupération de la matrice d'adjacence
            double[][] matriceAdjacence = lectureFichier.matriceAdjacence(grapheTraiter);

            //Etape 2 On effectue l'algorythme de floyd avec affichage des matrice intermédiaires
            Floyd matricesFinale = Floyd.algorythmeFloyd(matriceAdjacence);
            
            //Etape 3 on propose l'affichage des chemins les plus cours
            //on récupère la liste des chemins possibles 
            LectureChemin cheminsPossibles = new LectureChemin();
            cheminsPossibles.listeCheminsPossibles(matricesFinale.getMatriceP());
            //on les affiches en mettant avant le numéro à saisir pour la sélection
            System.out.println(cheminsPossibles);
            
            //on récupère le choix de l'utilisateur et on vérifie que ce choix est proposé dans la liste
            Scanner scanner = new Scanner(System.in);
            int cheminChoisit = scanner.nextInt();
            int nbrCheminsPossibles = cheminsPossibles.getNombreChemins();

            while(cheminChoisit > nbrCheminsPossibles && cheminChoisit < 0 ){
                System.out.println(cheminsPossibles);
                cheminChoisit = scanner.nextInt();
            }
        }

    }
}
