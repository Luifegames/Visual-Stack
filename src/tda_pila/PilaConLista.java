/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda_pila;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pepe
 */
public class PilaConLista <E> implements Pila <E>{
    private ArrayList l;

    public PilaConLista() {
        l = new ArrayList();
    }

    
    @Override
    public void push(E elem) {
            l.add((Comparable) elem);
    }

    @Override
    public void pop() throws PilaVacia {
        if (l.isEmpty()){
            throw new PilaVacia();
        } else {
           
                l.remove(l.size()-1);
            
        }
    }
    

    @Override
    public E top() throws PilaVacia {
         if (l.isEmpty()){
            throw new PilaVacia();
        } else {
          
                return (E) l.get(l.size()-1);
            
            
        }
    }
    @Override
    public boolean isEmpty(){
      return l.isEmpty();
  }
}
   
