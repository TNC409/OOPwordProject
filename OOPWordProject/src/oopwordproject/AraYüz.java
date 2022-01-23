package oopwordproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*; 
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AraYüz extends JFrame implements ActionListener{
     JFrame framee;
     JButton gerial, cıkıs,onayla,degistir,metni_onayla;
     JLabel a,b,c;
     JTextField metin, kelime_ara,kelime_degistir ,duzelmis_metin;
     
     public String input_aranacak_kelime;    // arama yapmak için girilen kelimeyi tutacak string değişkeni
     public int kontrolcu;
     public String input_metin;                //Girilen metin 
     public static String[] aranacak;               //Girilen kelime dizinini split edip içine atmak için oluşturduğumuz tek boyutlu dizi
     public static ArrayList<String> listem =new ArrayList();
     public static ArrayList<String> duzeltilmis_listem=new ArrayList(); //kontrol edilip düzeltilen  metin burada tutluacak içinden arama değiştirme ve  harf harf silme işlemi yapılacak
    
     
 
     AraYüz(){
  
         
    framee =new JFrame("Notepad Example");  //frame oluşturduk
    
    //burada kullancağımız label'ları oluşturduk
    a=new JLabel("Metin Girin");
    b =new JLabel("Aramak istedigin kelimeyi gir");
    c=new JLabel("Degistirmek istedigin kelimeyi gir");
    
    //kullanılacak  JText Field'leri oluşturduk
    kelime_ara=new JTextField("");
    kelime_degistir=new JTextField("");
    metin =new JTextField("");
    duzelmis_metin=new JTextField();
    
    //bunları oluşturduk
    gerial =new JButton("Geri Al");
    cıkıs=new JButton("Cıkıs");
    onayla =new JButton("Aranacak kelimeyi Onayla");
    degistir =new JButton("Buldugun kelimeyi Degistir");
    metni_onayla=new JButton("Metni onayla");
    
    //burada oluşturduğumuz tool'ların konumlarının set ettik
    metin.setPreferredSize(new Dimension(350, 200));
    kelime_ara.setPreferredSize(new Dimension(170, 20));
    kelime_degistir.setPreferredSize(new Dimension(170, 20));
    duzelmis_metin.setPreferredSize(new Dimension(400,250));

            
    //butonlarala işlem yapabilmek için acitonListener'ları tanımladık 
    gerial.addActionListener(this);
    cıkıs.addActionListener(this);
    onayla.addActionListener(this);
    degistir.addActionListener(this);  
    metni_onayla.addActionListener(this);
            
    
    //burada oluşturduğumuz elemanların hepsini frame'e ekledik
    framee.add(a);
    framee.add(metin);
    framee.add(metni_onayla);

    framee.add(b);
    framee.add(kelime_ara);
    framee.add(onayla);

    framee.add(c);
    framee.add(kelime_degistir);
    framee.add(degistir);
    framee.add(duzelmis_metin);

    framee.add(gerial);
    framee.add(cıkıs);

    

    
    framee.setSize(600,500);
    framee.setLayout(new FlowLayout());
    framee.setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }  
      SimpleRemoteControl remotee = new SimpleRemoteControl(); 
      GeriAlici ga = new GeriAlici(); 
      
      NameRepository np =new NameRepository();
      Expression aranacak_kkelime;
     
      
     
   public void actionPerformed(ActionEvent e) {  
       NotePadIslemleri not=new NotePadIslemleri();
       Controller controller=new Controller();
        controller.setDosya();
         if(e.getSource()==cıkıs){   //eger çıkışa basılırsa işlem yapılmış ve bitmiş kelimeleri yeni bir texte'e yazıp uygulamadan çıkarız
             
         //    try {                
            //     BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File("duzeltilmis.txt"), true)); //düzeltilmiş kelimelerden olusan txt dosyamızı yazmak için açtık
                 controller.open();
             //    for(String ds: duzeltilmis_listem){
                     
               //      myWriter.write(ds);
             //        myWriter.newLine();
                    
              //   }
             //    myWriter.close();
                 controller.save();
                 controller.close();
                 System.exit(0);
           //  } 
             
           //  catch (IOException ex) {
             //    System.out.println("Duzeltilmis text açılamadı");
           //  } //end of catch
         }
         
         
         else if(e.getSource()==onayla){    //kelime arama işlemi onaylanınca yapıalcak işlemleri belirttik 
            
             
             input_aranacak_kelime=kelime_ara.getText().toString();
             
             
            aranacak_kkelime=new TerminalExpression(input_aranacak_kelime);
            
             if(aranacak_kkelime.interpret()==true){
                 JOptionPane.showMessageDialog(null,"Aranılan kelime var bunu ne ile degistirmek istiyorsanız degistir kısmına giriniz" );
                  kontrolcu=1;
             }
            
            
           //  if(duzeltilmis_listem.contains(input_aranacak_kelime)){
                 
         //    }
             
             else{
                 JOptionPane.showMessageDialog(null,"Aradığınız kelime bulunmamakta kelime degistirmek için bulunan bir kelime giriniz");
                 kontrolcu=0;
             }
         }  
         
         
         else if(e.getSource()==gerial){ //harf harf geri alma işleminde yapılacak işlemleri tanımladık 
             
             remotee.setCommand(new Geri(ga));
             remotee.buttonWasPressed();
             yazdir();
             
            
         }
         
         
         else if(e.getSource()==degistir){ //eğer aradığımı kelimeyi bulduysak burada yeni girelen kelime ile değiştiriyoruz
             if (kontrolcu==1){
                 String kelime_ara_field=kelime_ara.getText().toString();  //aranacak kelimenin array listeki indexini bulmak için bunu kullandık
                 String kelime_degis=kelime_degistir.getText().toString(); //burada da degistireceğimiz kelimeyi tuttuk
                  int index = duzeltilmis_listem.indexOf(kelime_ara_field); //burada degismesi istenin  kelimenin indexini bulduk
                  duzeltilmis_listem.set(index, kelime_degis);    //burada da kelimemizi degistirdik
         
              
                //değiştirdikten sonra burada güncel halini yazdırıyoruz
                yazdir();
         
                 
             }
         }
         

         else if(e.getSource()==metni_onayla){ //girilen metini onaylama işlemi yani düzeltmeler yapılacak 
          
             aranacak = metin.getText().split("[, ?.@;:/]+");
             try {
                 not.arama();
             } 
             catch (IOException ex) {
                 System.out.println("Arama metodhu cagrılamadı");
             }
             StringBuffer string_buffer = new StringBuffer(); 
             String a;
             for(String ds: duzeltilmis_listem){
                     
                     string_buffer.append(" "+ds);
                 }
             a=string_buffer.toString();
             duzelmis_metin.setText(a);
         }
    }
   public void yazdir(){
         //burada da işlem yaptıktan sonra  güncel hali yazdırırız 
         
                StringBuffer string_buffer = new StringBuffer(); 
             String a;
             for(Iterator iter =np.getIterator(); iter.hasNext();){
                
                 String name =(String)iter.next();
                 
                  string_buffer.append(" "+name);
                  a=string_buffer.toString();
                  duzelmis_metin.setText(a);  
                 }
    //         for(String ds: duzeltilmis_listem){
      //               
        //          string_buffer.append(" "+ds);
                                                
            // a=string_buffer.toString();
          //   duzelmis_metin.setText(a);  
   }
}
   
    
