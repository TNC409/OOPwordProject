
package oopwordproject;

import static oopwordproject.AraYüz.duzeltilmis_listem;

public class NameRepository implements Container{
    
    //düzeltilmiş_listem kullanacağımı arraylist 
     
    @Override
    public Iterator getIterator(){
        return new NameIterator();
    }
    
    private class NameIterator implements Iterator{
        
        int index;
        
        @Override
        public boolean hasNext(){
            if(index<duzeltilmis_listem.size())
                return true;
            return false;
        }
        @Override
        public Object next(){
            if(this.hasNext()){
                return duzeltilmis_listem.get(index++);
            } //end of if 
            else{
                return null;
            } //end of else 
        } // end of next methode
    }
    //end of private class 
} // end of public class 
