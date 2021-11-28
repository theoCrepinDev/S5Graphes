import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class LectureChemin {
    static int inf = Integer.MAX_VALUE; //permet de représenter l'infini
    //variable d'instance contenant la liste des chemins possibles
    private  ArrayList<CouplesEntiers> cheminsPosibles;

    //constructeur
    public LectureChemin(){
        this.cheminsPosibles = new ArrayList<>();
    }

    //méthode permettant de récupérer le couple (départ arrive ) à l'indice i
    public CouplesEntiers getCheminI(int i){
        return this.cheminsPosibles.get(i);
    }
    
    //méthode pour récupérer le nombre de chemin possibles
    public int getNombreChemins(){
        return this.cheminsPosibles.size();
    }

    //récupère le couple à l'indice i
    public CouplesEntiers get(int i){
        return this.cheminsPosibles.get(i);
    }
    
    //méthode toString pour l'affichage des chemin possibles avec le choix
    @Override
    public String toString(){
        int len = this.cheminsPosibles.size();
        String affichage = "";
        affichage += "Voici les chemins possibles \n";
        affichage += "veuillez en sélectionner un :\n";
        for(int i = 0; i < len; i++){
            affichage += (i + 1) + " : chemin de " + cheminsPosibles.get(i).getVal1() + " vers : " + cheminsPosibles.get(i).getVal2() + " \n";
        }
        return affichage;
    }
    
    //fonction qui permet de renvoyer un tableau 
    //des chemin possibles qui prend en arguments une matrice des prédécesseurs
    public ArrayList<CouplesEntiers> listeCheminsPossibles(double[][] matriceP){
        int len = matriceP.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(matriceP[i][j] != -1){
                    CouplesEntiers cheminTrouve = new CouplesEntiers(i ,j );
                    this.cheminsPosibles.add(cheminTrouve);
                }
            }
        }        
        return cheminsPosibles;
    }
    

    // fonction pour permettre la lecture d'un chemin à partir de la matrice de prédécesseurs
    //la longeure max est le nombre de sommets présent dans le graphes
    public static ArrayList<Integer> rechercheChemin(double[][] matricePrede, int depart, int arrivee){
        ArrayList<Integer> resultat = new ArrayList<>();
        resultat.add(arrivee);
        double predecActuel = matricePrede[depart][arrivee];
        if(matricePrede[depart][arrivee] == inf){
            resultat.add(-1);
        }
        else{
            while(predecActuel != depart){
                resultat.add((int) predecActuel);
                predecActuel = matricePrede[depart][(int) predecActuel];
            }
            resultat.add((int) predecActuel);
        }
        return resultat;
    }

    public static void affichageChemin(ArrayList<Integer> liste){
        int len = liste.size();
        System.out.println("affichage du chemin le plus court :");
        
        for(int i = len - 1; i >= 0; i--){
            System.out.print(liste.get(i));
            if (i != 0){
                System.out.print("->");
            }
        }
        System.out.println("");
    }
}