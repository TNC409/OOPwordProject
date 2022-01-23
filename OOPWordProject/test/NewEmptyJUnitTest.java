
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oopwordproject.AraYüz;
import oopwordproject.NotePadIslemleri;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        System.out.println("Cleaning the screen");   
        if (System.getProperty("os.name").startsWith("Window"))
        Runtime.getRuntime().exec("cls");
        
        else {
            try{
                Runtime.getRuntime().exec("clear");
            }
        catch(IOException ex){
            Logger.getLogger(NewEmptyJUnitTest.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        Runtime r=Runtime.getRuntime();
        System.out.println("Collecting the garbage");
        r.gc();
    }

   

    
    
     
  
        
    
           

}
