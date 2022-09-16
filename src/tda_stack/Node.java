/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda_stack;

public class Node<E> {
    E info;
    Node<E> next;

    public Node(E info,  Node<E> next){
        this.info=info;
        this.next=next;
    }
    public Node(E info){
        this (info,null);
    }
    public Node(){
        next=null;
    }
}

