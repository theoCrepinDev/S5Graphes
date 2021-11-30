//class permettant la représentation de couples d'entiers
public class A5_CouplesEntiers {
    private int val1;
    private int val2;

    public A5_CouplesEntiers(){
        val1 = 0;
        val2 = 0;
    }
    public A5_CouplesEntiers(int val1, int val2){
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
