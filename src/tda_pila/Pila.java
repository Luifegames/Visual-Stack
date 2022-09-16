/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pepe
 */
package tda_pila;
public interface Pila <E> {
    /**
     * Método que pone un elemento en la pila
     * @param elem elemento a insertar en la pila
     */
    void push(E elem);
    /**
     * Método que elimina un elemento de la pila
     * NO lo devuelve
     */
    void pop() throws PilaVacia;
    /**
     * Método que devuelve el elemento próximo a salir de la pila
     * @return  elemento próximo a salir
     */
    E top() throws PilaVacia;
    /**
     * Método que determina si una pila está vací¬a o no
     * @return  verdadero si la pila está vací¬a, false en caso contrario
     */
    boolean  isEmpty();
}
