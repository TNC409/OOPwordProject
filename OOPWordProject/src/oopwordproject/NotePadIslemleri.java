
package oopwordproject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static oopwordproject.AraYüz.aranacak;
import static oopwordproject.AraYüz.duzeltilmis_listem;
import static oopwordproject.AraYüz.listem;


public class NotePadIslemleri {
    
    
    public void arama() throws IOException{
          String []lisss=new String[10];
     int uzunluk_tutucu; //bu sırası ile her satırdaki kelimenin uzunluğunu tutacak ve bu sayede o uzunlukta bir array oluşturacağız
     int aranacak_uzunluk_tutucu=0;  //aranacak dizisinin içindeki kelimerli harflere split edince içine atacağımız tek boyutlu array
   int a=0;
   try{
   File mf=new File("words.txt");  //açacağınmız text'î belirttik
    Scanner scanner = new Scanner(mf);  //burada okuduk
    while (scanner.hasNextLine()) {  //text'in tüm elemanlarını gezmek için while açtık 
    String line = scanner.nextLine();  //burada sırası ile sıradaki line'ı aldık
    uzunluk_tutucu=line.length();   //burada atama yapacağızmız uzunluk değişkenini atadık
    String []kontrol=new String[uzunluk_tutucu];    //text'en aldığımız kelimeleri split edip kontrol array'ine atadık
    
    
       kontrol=line.split("");  //split edip harfleri kontrol'ün içine attık 
       for(String gez: aranacak){ // for each ile aranacak arrayini gezipp split ediyoruz 
           aranacak_uzunluk_tutucu=gez.length(); // aranacak dizisindeki kelimelerin sırası ile uzunluklarını alıp buna uygun array oluşturacağız
            String []aranacaklari_tutacak=new String[aranacak_uzunluk_tutucu];  //oluşturacağımız array'in boyutunu belirttik
            aranacaklari_tutacak=gez.split("");  //split edip harflerini aranacaklari_tutacak içine attık 
            if((kontrol[0].equalsIgnoreCase(aranacaklari_tutacak[0]))|| (kontrol[0].equalsIgnoreCase(aranacaklari_tutacak[1]))){ //yani ilk ya da ikinci harfleri aynı ise bunları array liste'e at bu sayede tüm words'ü gezmek yerine singel transposition olma ihtiammli olanlara bakmış oluruz.
                
                listem.add(line);
            }  //end of if 

            
       } //en of for each
 
  
    }  //end of the while
    scanner.close();  //Açtığımız text'i kapattık
    
     int belirleyici=0;  //listee array'inin boyutunu belirtecek int degiskeni
    
     for(String ls:aranacak){ // burada text'e göre  doğru olma ihtimali olan kelimeler var şimdi onları kontrol edip düzelteceğiz
      belirleyici=ls.length();  //array'in boyutunu  belirlemek için kullnacağımız değisken.
      
       String[] listee= new String[belirleyici]; //bu listede harf harf olacak şekilde kelimeleri tutacağız kontrol için , o array'in boyutunu belirttik.
       listee=ls.split("");    //kelimeyi harflerine böldük
      
        int ara=0;
      for(String gezz: listem){
          aranacak_uzunluk_tutucu=gezz.length();
          String []son_kontrol_arrayi=new String[aranacak_uzunluk_tutucu];
          son_kontrol_arrayi=gezz.split("");  //içinde harf harf kelimeleri tutacak arrayimiz
          
          
          if(ls.equalsIgnoreCase(gezz)){ //yani kelimeler aynı ise bu dogru demektir bir islem yapma zaten kelime doğru demektir.
              
            
               
               duzeltilmis_listem.add(ls);
                ara=1;
                 break;

          }
          
  
          
       
          
          else if(belirleyici ==aranacak_uzunluk_tutucu){  //eğer kelimeler eşit uzunlukta ise bakılır
              
              int cikis=0;
           
              String ilk_harf_tutucu;  //switch yapılan harfleri tutacak degiskenler
              String ikinci_harf_tutucu;
          
              for(int i=0;i<belirleyici-1;i++){ //burada kontrol edilecek kelimenin 1 eksiği kadar dönecek bir for döngüsü far harfleri switch edip kontrol edeceğiz
                ilk_harf_tutucu= son_kontrol_arrayi[i]; //burada ilk ve ikinci harflşeri aldık
                ikinci_harf_tutucu=son_kontrol_arrayi[i+1];
                son_kontrol_arrayi[i]=ikinci_harf_tutucu; //burada aldığımız harfleri swtich ettik
                son_kontrol_arrayi[i+1]=ilk_harf_tutucu;
              
               
                   if (Arrays.equals(son_kontrol_arrayi, listee)){
            
                    duzeltilmis_listem.add(gezz);
                       ara=1;
                       cikis=1;
                       break;
                       
                       
                       
                   }//  end of array vomparison if 


                 son_kontrol_arrayi[i]=ilk_harf_tutucu; //bu harfler arası single transposition yokmuş o harfleri düzelttik şimdi diğer harflere bakacağız
                son_kontrol_arrayi[i+1]=ikinci_harf_tutucu;
                
                              
                 
                  
                     } // en of for
                     if(cikis==1)
                         break;

          }  // end of else if 
 

         
       }// end of for each  aranacak
      
  
      if(ara==0){
         
           duzeltilmis_listem.add(ls);
      }
    
    }//end of for each listem 
      


   
   }  //end of try 
   catch(Exception e){
       System.out.println("Hataa ");
   }  //end of catch 
    } // end of arama method
}


