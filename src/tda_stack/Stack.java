
package tda_stack;

public class Stack<E> {

    private Node<E> head;

    public Stack() {
        head = new Node<E>();
    }

    public void push(E elem) {
        Node<E> tmp = new Node<E>(elem);
        tmp.next = head.next;
        head.next = tmp;
    }

    public void pop() throws EmptyStack{
        if (isEmpty()) {
            throw new EmptyStack();
        } else {
            head.next = head.next.next;
        }
    }

    public E top() throws EmptyStack{
        if (isEmpty()) {
            throw new EmptyStack();
        } else {
            return head.next.info;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}
