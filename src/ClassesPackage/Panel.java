package ClassesPackage;

import com.sun.javafx.util.Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import tda_stack.EmptyStack;

public class Panel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    private VisualStack vs;
    private float ypos, ydes, ydrag;
    private Point pMouse;
    private TextField tf;
    private Button bpush, bpop;

    public Panel() {
        vs = new VisualStack();
        pMouse = new Point(); //Position of the mouse
        ypos = 0; // y-position of the stack 
        ydrag = 0;//pivot y-position 
        bpush = new Button(120, 40, 50, 22, "PUSH");
        bpop = new Button(180, 40, 50, 22, "POP");
        tf = new TextField(10, 40, 100, 20, 0xffffffff);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Set the font
        g2.setFont(new Font("Roboto", 0, 10));

        //Active the smooth antialaliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw the background
        Shape r = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.setPaint(new Color(0xaccaca));
        g2.draw(r);
        g2.fill(r);

        update();

        //Visual Stack draw
        vs.draw(g2);

        //Buttons draw
        bpop.draw(g2);
        bpush.draw(g2);

        //TextField draw
        tf.draw(g2);

        g2.setPaint(Color.black);
        g2.setFont(new Font("Roboto", 0, 20));
        g2.drawString("TOP", 0, 100);
        g2.setFont(new Font("Roboto", 0, 40));
        try {
            g2.drawString(vs.top() + "", 0, 140);
        } catch (EmptyStack ex) {
            g2.drawString(  "-", 0, 140);
        }

        setOpaque(false);
        super.paintComponents(g2);
    }

    //Update 
    public void update() {
        vs.update(getWidth() / 2, getHeight() - 35 + (int) ypos);
        //ydes is the position
        //ypos is the interpolation between both position
        ypos += (ydes - ypos) * 0.1f;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //Drag
        if (vs.getC() > 6) { //if the Stack size is 6 or more
            ydes = e.getY() - ydrag; //update the y-position 
            ydes = Utils.clamp(0, ydes, vs.getC() * 35 - getHeight() / 2);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pMouse.setPoint(e.getX(), e.getY());

        bpush.update(e);
        bpop.update(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        ydrag = e.getY() - ydes;

        if (e.getButton() == 1) { //if press left button 

            if (bpush.isEntered()) { // if is in button push

                //if the textfield isn´t empty
                if (!tf.getText().equals("")) {

                    //put the value in the stack
                    vs.push(Integer.parseInt(tf.getText()));

                    //update the  y-position
                    if (vs.getC() > 6) {
                        ydes = vs.getC() * 35 - getHeight() / 2;

                    } else {
                        ydes = 0;
                    }
                    //Clean the text field
                    tf.setText("");
                }
            }
            if (bpop.isEntered()) {// if is in button pop
                try {
                    vs.pop();

                    //update the  y-position
                    if (vs.getC() > 6) {
                        ydes = vs.getC() * 35 - getHeight() / 2;

                    } else {
                        ydes = 0;
                    }

                } catch (EmptyStack ex) {
                    System.err.println("Stack is empty");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int ENTER = 10;
        int BACKSPACE = 8;
        if (e.getKeyCode() != ENTER && e.getKeyCode() != BACKSPACE) {

            //Only type numbers
            if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
                tf.setText(tf.getText() + e.getKeyChar());
            }

        } else {
            if (e.getKeyCode() == BACKSPACE) {

                if (tf.getText().length() > 1) {

                    String s = tf.getText();
                    tf.setText(s.substring(0, s.length() - 1));

                } else {

                    tf.setText("");

                }
            } else if (e.getKeyCode() == ENTER) {

                if (!tf.getText().equals("")) {

                    vs.push(Integer.parseInt(tf.getText()));

                    if (vs.getC() > 6) {
                        ydes = vs.getC() * 35 - getHeight() / 2;
                    }
                    tf.setText("");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void drawCenteredString(String s, int offsetX, int offsetY, int w, int h, Graphics2D g) {
        g.setFont(new Font("Roboto", 0, 15));
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2 + offsetX;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2) + offsetY;
        g.drawString(s, x, y);
    }

}
