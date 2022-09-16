/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda_pila;
/**
 *
 * @author pepe
 */

public class Nodo<E> {
    E info;
    Nodo<E> next;

    public Nodo(E info,  Nodo<E> next){
        this.info=info;
        this.next=next;
    }
    public Nodo(E info){
        this (info,null);
    }
    public Nodo(){
        next=null;
    }
}

