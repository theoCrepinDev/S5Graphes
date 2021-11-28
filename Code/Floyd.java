public class Floyd {
    static int inf = Integer.MAX_VALUE; //permet de représenter l'infini
    private double[][] matriceL;
    private double[][] matriceP;

    public Floyd(double[][] matriceL, double[][] matriceP){
        this.matriceL = matriceL;
        this.matriceP = matriceP;
    }

    //méthodes get
    public double[][] getMatriceP(){
        return this.matriceP;
    }

    public double[][] getMatriceL(){
        return this.matriceL;
    }
    
    public static Floyd algorythmeFloyd(double[][] matriceAdjacence){
        int len = matriceAdjacence.length;
        System.out.println(len);

        double[][] matriceL = new double[len][len];
        double[][] matriceP = new double[len][len];
        //copie de la matrice d'adjacence dans L
        //et initialisation de P
        
        for (int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                matriceL[i][j] = matriceAdjacence[i][j];
                if(matriceL[i][j] != inf){
                    matriceP[i][j] = i;
                }
                else{
                    matriceP[i][j] = -1;
                }
            }
        }
        //affichage des matrice avant les itérations
        System.out.println("affichage matrice des poids avant itérations");
        lectureFichier.affichageMatrice(matriceL);
        System.out.println("affichage matrice des prédécesseurs avant itérations");
        lectureFichier.affichageMatrice(matriceP);

        //les matrice sont initialisé on va commencer les itération sur
        for(int k = 0; k < len; k++){
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    /*
                    System.out.println(matriceL[i][j]);
                    System.out.println(matriceL[i][k]);
                    System.out.println(matriceL[k][j]);
                    */
                    // j'ajoute la condition de i différent de j car on a pas besoins de parcourir le graphe 
                    if(matriceL[i][j] > (matriceL[i][k] + matriceL[k][j])){
                        matriceL[i][j] = matriceL[i][k] + matriceL[k][j];
                        matriceP[i][j] = matriceP[k][j];
                    }
                }
            }
            //affichage des matrice intermédiaires
            System.out.println("affiche de la matrice des poids après l'étape :" + k);
            lectureFichier.affichageMatrice(matriceL);
            System.out.println("affiche de la matrice des prédécesseurs après l'étape :" + k);
            lectureFichier.affichageMatrice(matriceP);
        }
        return new Floyd(matriceL, matriceP);
    }
}
