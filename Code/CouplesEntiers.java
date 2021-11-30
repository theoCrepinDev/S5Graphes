//class permettant la représentation de couples d'entiers
//pour représenter les sommets de départ et d'arrivée
public class CouplesEntiers {
    private int val1;
    private int val2;

    public CouplesEntiers(){
        val1 = 0;
        val2 = 0;
    }
    public CouplesEntiers(int val1, int val2){
        this.val1 = val1;
        this.val2 = val2;
    }    

    public int getVal1(){
        return this.val1;
    }
    
    public int getVal2(){
        return this.val2;
    }
}
