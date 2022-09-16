/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Button {

    private Point p;
    private int w, h;
    private String text;
    private boolean entered;

    public Button(int x, int y, int w, int h, String text) {
        p = new Point(x, y);
        this.w = w;
        this.h = h;
        this.text = text;
    }

    public void update(MouseEvent e ){
        entered =  (e.getX() > p.getX() && e.getX() < p.getX() + w &&
            e.getY() > p.getY() && e.getY() < p.getY() + h);

    }
    
    
    
    public void draw(Graphics2D g2) {
        g2.setPaint(new Color(0x3f3f74));
        g2.setFont(new Font("Arial", 0, 15));
        g2.fillRoundRect((int) p.getX(),(int) p.getY(), w, h,10,10);
        Color c;
        c = entered? Color.yellow:Color.white;
        g2.setPaint(c);
        
        g2.drawString(text, p.getX()+w/2 - 5*text.length(), p.getY() + 16);
    }

    public void setP(int x, int y) {
        this.p = new Point(x, y);
    }

    public boolean isEntered() {
        return entered;
    }

    
    
    
}
