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

        double[][] matriceL = new double[len][len];
        double[][] matriceP = new double[len][len];
        boolean circuitAbsorbant = false;
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
        //affichage des matrices avant les itérations
        System.out.println("affichage matrice des poids avant itérations");
        A5_LectureFichier.affichageMatrice(matriceL);
        System.out.println("affichage matrice des prédécesseurs avant itérations");
        A5_LectureFichier.affichageMatrice(matriceP);

        //les matrices sont initialisées on va commencer les itérations sur
        for(int k = 0; k < len; k++){
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    /*
                    System.out.println(matriceL[i][j]);
                    System.out.println(matriceL[i][k]);
                    System.out.println(matriceL[k][j]);
                    */
                    if(matriceL[i][j] > (matriceL[i][k] + matriceL[k][j]) && (matriceL[k][j] != inf && matriceL[i][k] != inf)){
                        matriceL[i][j] = matriceL[i][k] + matriceL[k][j];
                        matriceP[i][j] = matriceP[k][j];
                    }
                }
                //détection de circuits absorbants (valeure négative sur la diagonale)
                if(matriceL[i][i] < 0){
                    circuitAbsorbant = true;
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
