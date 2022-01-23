package oopwordproject;

import static oopwordproject.AraYüz.duzeltilmis_listem;


public class GeriAlici {
 
    
        public void execute_gerialma() {
             String gecici=duzeltilmis_listem.get(duzeltilmis_listem.size()-1); //burada array'in son elemanını aldık
           
             if(gecici.length()==1){ //eğer tek harf ise direk son elemanı sileriz 
                 
                 duzeltilmis_listem.remove(duzeltilmis_listem.size()-1);
             }
             else{
                 int harf_sayisi=gecici.length();
                 
                 String[] geri_alma_listesi= new String[harf_sayisi]; //son kelimenin harf sayısı uzunluğunda bir array oluşuturduk
                  StringBuffer string_bufferim = new StringBuffer(); 
                 geri_alma_listesi=gecici.split("");
                 for(int i =0;i<harf_sayisi-1;i++){ //harf sayısının 1 eksiği kadar döndürdük yani son harfi almaycak demek bu 
                     
                     string_bufferim.append(geri_alma_listesi[i]);
                 }
                 duzeltilmis_listem.set(duzeltilmis_listem.size()-1, string_bufferim.toString());
                   
             }
           
}
        
}

