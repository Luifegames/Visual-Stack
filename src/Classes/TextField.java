/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class TextField {

    private Point p, pAnchor;
    private int w, h,color;
    private String text;

    public TextField(int x, int y, int w, int h,int color) {
        p = new Point(x, y);
        pAnchor = new Point();
        this.w = w;
        this.h = h;
        this.color = color;
        text = "";
        
    }

    public void draw(Graphics2D g2) {
        Point pTemp = new Point( p.getX(),p.getY());
        pAnchor.setPoint(pTemp);
        {
            Shape r4 = new Rectangle2D.Double(pAnchor.getX(), pAnchor.getY(), w, h);
            g2.setPaint(new Color(color));
            g2.draw(r4);
            g2.fill(r4);

            g2.setFont(new Font("Roboto", 0, 15));
            g2.setPaint(Color.black);
            String t = text;
            if (t.length() > 11){
                int i = t.length() - 11; 
                t = t.substring(i, text.length());
            }
            g2.drawString(t + " |", pAnchor.getX(), pAnchor.getY() + 16);

        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setP(Point p) {
        this.p = p;
    }

}
