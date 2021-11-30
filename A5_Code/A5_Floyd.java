public class A5_Floyd {
    static int inf = Integer.MAX_VALUE; //permet de représenter l'infini
    private double[][] matriceL;
    private double[][] matriceP;
    private boolean circuitAbsorbant;

    public A5_Floyd(double[][] matriceL, double[][] matriceP,Boolean circuitAbsorbant){
        this.matriceL = matriceL;
        this.matriceP = matriceP;
        this.circuitAbsorbant = circuitAbsorbant;
    }

    //méthodes get
    public double[][] getMatriceP(){
        return this.matriceP;
    }

    public double[][] getMatriceL(){
        return this.matriceL;
    }
    
    public boolean aCircuitAbs(){
        return circuitAbsorbant;
    }

    public static A5_Floyd algorythmeFloyd(double[][] matriceAdjacence){
        int len = matriceAdjacence.length;
        System.out.println(len);

        double[][] matriceL = new double[len][len];
        double[][] matriceP = new double[len][len];
        boolean circuitAbsorbant = true;
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
        A5_LectureFichier.affichageMatrice(matriceL);
        System.out.println("affichage matrice des prédécesseurs avant itérations");
        A5_LectureFichier.affichageMatrice(matriceP);

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
                    if(matriceL[i][j] > (matriceL[i][k] + matriceL[k][j]) && (matriceL[k][j] != inf && matriceL[i][k] != inf)){
                        matriceL[i][j] = matriceL[i][k] + matriceL[k][j];
                        matriceP[i][j] = matriceP[k][j];
                    }
                    //détection de circuit absorbant (valeure négative sur la diagonale)
                    if(i == j && matriceP[i][j] < 0){
                        circuitAbsorbant = true;
                    }
                }
            }

            //affichage des matrice intermédiaires
            System.out.println("affiche de la matrice des poids après l'étape :" + k);
            A5_LectureFichier.affichageMatrice(matriceL);
            System.out.println("affiche de la matrice des prédécesseurs après l'étape :" + k);
            A5_LectureFichier.affichageMatrice(matriceP);
        }
        return new A5_Floyd(matriceL, matriceP, circuitAbsorbant);
    }
}
