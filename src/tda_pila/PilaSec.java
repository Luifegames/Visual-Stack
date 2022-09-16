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

/**
 * Clase que implementa una pila utilizando un arreglo.
 * Es un clase genérica.
 * @author Romel Vázquez Rodríguez
 */
public class PilaSec<E> implements Pila<E> {

    private E[] l;
    int tope;

    /**
     * Constructor que crea un pila vací¬a.
     * Inicialmente con 10 posiciones
     */
    public PilaSec() {
        Object[] l1 = new Object[10];
        l = (E[]) l1;
        tope = -1;
    }

    /**
     * Método que pone un elemento en la pila.
     * Aumenta el tamaí±o del arreglo si es necesario.     *
     * @param elem elemento a poner en la pila
     */
    public void push(E elem) {
        if (tope + 1 == l.length) {
            Object[] tmp = new Object[l.length + 10];
            System.arraycopy(l, 0, tmp, 0, l.length);
            l = (E[]) tmp;
        }
        l[++tope] = elem;
    }

    /**
     * Método que saca un elemento de la pila
     * @throws PilaVacia se eleva cuando se trata de sacar un elemento de una
     *         pila vací¬a
     */
    public void pop() throws PilaVacia {
        if (tope == -1) {
            throw new PilaVacia();
        } else {
            tope--;
        }
    }

    /**
     * Método que devuelve el próximo elemento a salir de la pila
     * @return elemento a salir de la pila
     * @throws PilaVacia se produce cuando se intenta tratar con una pila vací¬a
     */
    public E top() throws PilaVacia {
        if (tope == -1) {
            throw new PilaVacia();
        } else {
            return l[tope];
        }
    }

    /**
     * Método que determina si una pila está vací¬a o no
     * @return true si la pila está vací¬a, false en caso contrario.
     */
    public boolean isEmpty() {
        return tope == -1;
    }
}

