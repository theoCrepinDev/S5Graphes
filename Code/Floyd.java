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
        double[][] matriceL = new double[len][len];
        double[][] matriceP = new double[len][len];
        //copie de la matrice d'adjacence dans L
        //et initialisation de P
        for (int i = 0; i < len; i++){
            for(int j = 0; j > len; j++){
                matriceL[i][j] = matriceAdjacence[i][j];
                if(matriceL[i][j] != inf){
                    matriceP[i][j] = i;
                }
            }
        }
        //les matrice sont initialisé on va commencer les itération sur
        for(int k = 0; k < len; k++){
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++){
                    if(matriceL[i][j] >= (matriceL[i][k] + matriceL[k][j])){
                        matriceL[i][j] = matriceL[i][k] + matriceL[k][j];
                        matriceP[i][j] = k;
                    }
                }
            }
            //affichage des matrice intermédiaires
            System.out.print("affiche de la matrice des poids après l'étape ;" + k);
            lectureFichier.affichageMatrice(matriceL);
            System.out.print("affiche de la matrice des prédécesseurs après l'étape ;" + k);
            lectureFichier.affichageMatrice(matriceP);
        }
        return new Floyd(matriceL, matriceP);
    }
}
