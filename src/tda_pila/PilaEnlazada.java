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


public class PilaEnlazada<E> implements Pila<E> {

    private Nodo<E> head;

    public PilaEnlazada() {
        head = new Nodo<E>();
    }

    public void push(E elem) {
        Nodo<E> tmp = new Nodo<E>(elem);
        tmp.next = head.next;
        head.next = tmp;
    }

    public void pop() throws PilaVacia {
        if (isEmpty()) {
            throw new PilaVacia();
        } else {
            head.next = head.next.next;
        }
    }

    public E top() throws PilaVacia {
        if (isEmpty()) {
            throw new PilaVacia();
        } else {
            return head.next.info;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}
