/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPackage;

import java.io.Serializable;

public class Point implements Serializable{
    private float x,y;

    public Point() {
        x = 0;
        y = 0;
    }
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    public void Interpolation(Point p,float i){
        x += (p.x - x)*i;
        y += (p.y - y)*i;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    
    public void setPoint(Point p) {
        x = p.getX();
        y = p.getY();
    }
    
    
    public void setPoint(int x,int y) {
        this.x = x;
        this.y = y;
    }
    

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + " , Y: " + y; 
    }
    
    
}
