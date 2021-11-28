import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean a= true;
    public static void main(String args[]) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        
        String grapheTraiter = "Code/";

        int autreGraphe;
        //while true pour que le programme tourne en boucle
        //on commence par demander le nom du fichier du graphe a traiter
        System.out.println("Entrer le nom du fichier graphe (grapheX.txt) :");
        grapheTraiter += scanner.nextLine();
        
        while(a){
            //y a t-il plusieurs graphes par fichier texte ou chaques graphe a son propre fichier ?
            //a coder interface de gestion de la demande degraphe et on dit que le graphe à retourner se situe dans le dossier
            //test.txt soit dans la variable grapheTraiter
        
            //Etape 1 récupération de la matrice d'adjacence
            double[][] matriceAdjacence = lectureFichier.matriceAdjacence(grapheTraiter);
            lectureFichier.affichageMatrice(matriceAdjacence);

            //Etape 2 On effectue l'algorythme de floyd avec affichage des matrice intermédiaires
            Floyd matricesFinale = Floyd.algorythmeFloyd(matriceAdjacence);
            

            //Etape 3 on propose l'affichage des chemins les plus cours
            //on récupère la liste des chemins possibles 
            LectureChemin cheminsPossibles = new LectureChemin();
            cheminsPossibles.listeCheminsPossibles(matricesFinale.getMatriceP());
            //Boucle d'affichage des chemins les plus courts tant que l'utilisateur ne veut pas s'arreter
            boolean continuer = true;
            while(continuer){
                //on les affiches en mettant avant le numéro à saisir pour la sélection
                System.out.println("Entrer 0 pour sortir de l'étude de ce graphe");
                System.out.println(cheminsPossibles);
            
                //on récupère le choix de l'utilisateur et on vérifie que ce choix est proposé dans la liste
                int cheminChoisit = scanner.nextInt();
                int nbrCheminsPossibles = cheminsPossibles.getNombreChemins();
                if(cheminChoisit == 0){
                    continuer = false;
                }
                else{
                    while(cheminChoisit > nbrCheminsPossibles || cheminChoisit < 0 ){
                        System.out.println(cheminsPossibles);
                        cheminChoisit = scanner.nextInt();
                    }

                    if(cheminChoisit == 0){
                        continuer = false;
                    }
                    else{
                        //récupération de la iste qui représente le chemin le plus court
                        int depart = cheminsPossibles.get(cheminChoisit - 1).getVal1();
                        int arrivee = cheminsPossibles.get(cheminChoisit - 1).getVal2();
                        ArrayList<Integer> chemin = LectureChemin.rechercheChemin(matricesFinale.getMatriceP(), depart, arrivee );
                        //affichage du chmin
                        LectureChemin.affichageChemin(chemin);
                    }
                }
            }
            
            System.out.println("voulez vous étudier un autre graphe? (1: oui; 2: non)");
            autreGraphe = scanner.nextInt();
            if(autreGraphe == 2){
                a = false;
            }
            else{
                a = true;
                grapheTraiter = "Code/";
                System.out.println("Entrer le nom du fichier graphe (grapheX.txt) :");
                grapheTraiter += scanner.nextLine();
                grapheTraiter += scanner.nextLine();
            }
        }
        scanner.close();
    }
}
