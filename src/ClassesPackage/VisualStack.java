/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import tda_stack.EmptyStack;
import tda_stack.Stack;

public class VisualStack<E> extends Stack<E> {
    
    private ArrayList<E> n;//List of Elements
    private ArrayList<Boolean> des;
    private ArrayList<Point> pos;
    private int y, c;

    public VisualStack() {
        n = new ArrayList<>();
        pos = new ArrayList<>();
        des = new ArrayList<>();

        y = 0;
        c = 0;
    }

    @Override
    public void push(E elem) {
        n.add(elem);
        c++;
        pos.add(new Point(0, y - c * 35));
        des.add(true);
        super.push(elem);
    }

    @Override
    public void pop() throws EmptyStack {

        if (c > 0) {
            des.set(--c, false);
        }
        super.pop();
    }

    public void update(int x, int y) {
        this.y = y;
        for (int i = 0; i < n.size(); i++) {
            float xx = pos.get(i).getX();

            if (des.get(i)) {

                xx += (x - 40 - pos.get(i).getX()) * 0.04;

            } else {
                xx += (x * 3 - pos.get(i).getX()) * 0.01;
            }

            pos.get(i).setX(xx);
            pos.get(i).setY(y - i * 35);

            if (pos.get(i).getX() > 2 * x) {
                pos.remove(i);
                des.remove(i);
                n.remove(i);
            }
        }
    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < n.size(); i++) {
            g.setPaint(Color.getHSBColor(i * 0.05f, 0.8f, 0.8f));
            g.fillRoundRect((int) pos.get(i).getX(), (int) pos.get(i).getY(), 80, 30, 20, 20);
            g.setPaint(Color.getHSBColor(i * 0.05f, 1f, 0.8f));
            g.setStroke(new BasicStroke(4));
            g.drawRoundRect((int) pos.get(i).getX(), (int) pos.get(i).getY(), 80, 30, 20, 20);
            g.setPaint(new Color(0xffffff));
            Panel.drawCenteredString(n.get(i) + "", (int) pos.get(i).getX(), (int) pos.get(i).getY(), 80, 30, g);
        }

        
        
    }

   

    public int getC() {
        return c;
    }

}
