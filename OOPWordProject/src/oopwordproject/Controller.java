
package oopwordproject;


public class Controller  {
    public static DosyaIslemi ds;
    public static Connection con;

    public Controller() {
        
        ds=new DosyaIslemi();
        
    }
    public void setDosya(){
        con=ds;
        
    }
    public void open(){
        con.open();
    }
    
    public void close(){
        con.close();
        
    }
    
    public void save(){
        con.save();
    }
    
    
    
}
