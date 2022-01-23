
package oopwordproject;

import static oopwordproject.AraYüz.duzeltilmis_listem;

public class TerminalExpression implements Expression{
    
    
    private String data;

   public TerminalExpression(String data){
      this.data = data; 
   }
//constructor içine gelen ile karşılaştırıız var mı yok mu diye
   @Override
   public boolean interpret() {
   
        if(duzeltilmis_listem.contains(data)){
             return  true;
        }
        else{
            return false ;
        }
      
       //if(context.contains(data)){ //burada dosya içinden arama işlemi olacak
     //    return true;
     // }
     // return false;
  // }
   }
}
