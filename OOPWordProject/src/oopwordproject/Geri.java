
package oopwordproject;


public class Geri implements  Command{
    GeriAlici geriAlici;
    
    public Geri(GeriAlici geriAlici){
        this.geriAlici=geriAlici;
        
    }
    @Override
    public void execute_gerial(){
        geriAlici.execute_gerialma();
    }
}
