
package oopwordproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static oopwordproject.AraYüz.duzeltilmis_listem;


public class DosyaIslemi implements Connection {
     BufferedWriter myWriter;
    
    @Override
    public void open(){
        try {
             myWriter = new BufferedWriter(new FileWriter(new File("duzeltilmis.txt"), true)); //düzeltilmiş kelimelerden olusan txt dosyamızı yazmak için açtık   
             }  //end of try
        
        catch (IOException ex) {
       System.out.println("Duzeltilmis text açılamadı");

        } //end of catch 

        
    } //end of open function
    
    
    @Override
    public void close(){
         try {
             myWriter.close();
         } catch (IOException ex) {
           System.out.println("Dosya kapatılamadı");
         }
         
    } //end of close function
    
    @Override
    public void save(){
        

          for(String ds: duzeltilmis_listem){
                     
              try {
                  myWriter.write(ds);
                  myWriter.newLine();
              } //end of try
              
              catch (IOException ex) {
                  System.out.println("Dosyaya ekleme işleminde hata var");
              } //end of catch 
                     
                    
                 } //end of for
    } //end of save function
} //end of class 
