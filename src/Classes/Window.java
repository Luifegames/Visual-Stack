/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

    private  Panel p;
    private boolean running;
    
    public Window() throws HeadlessException {
        p = new Panel();
        addMouseListener(p);
        addMouseMotionListener(p);
        addKeyListener(p);
        
        setTitle("Stack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p);
        pack();
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void run() {
    running = true;
    
        while (running) {
            repaint();
        }
    dispose();
    }

}
